package ru.ifmo.rain.balahnin.parser

import GrammarForGrammarsBaseVisitor
import org.antlr.v4.runtime.tree.TerminalNode
import java.util.*

class FollowGeneratorVisitor(val first: Map<String, Set<String>>, val follow: MutableMap<String, MutableSet<String>>) :
    GrammarForGrammarsBaseVisitor<Void?>() {
    val parentFollowStack = Stack<Set<String>>()
    override fun visitGrammar_(ctx: GrammarForGrammarsParser.Grammar_Context?): Void? {
        super.visitGrammar_(ctx)
        var changed = true
        while (changed) {
            changed = false
            for ((k, v) in follow) {
                for ((innerK, innerV) in follow) {
                    if (v.contains(innerK)) {
                        v.remove(innerK)
                        v.addAll(innerV)
                        changed = true
                    }
                }
            }
        }
        for ((k, v) in follow) {
            if (v.contains("")) {
                v.remove("")
            }
        }
        return null
    }

    override fun visitParsingRule(ctx: GrammarForGrammarsParser.ParsingRuleContext?): Void? {
        if (ctx === null) {
            return null
        }
        val identifier = ctx.PARSER_IDENTIFIER().text
        if (follow.containsKey(identifier)) {
            parentFollowStack.push(follow[identifier]!!.asSequence().plusElement(identifier).toMutableSet())
        } else {
            parentFollowStack.push(mutableSetOf(identifier))
        }
        for (child in ctx.children.asReversed()) {
            if (child !is TerminalNode) {
                child.accept(this)
                val curFirst = firstByParsingAtom(child as GrammarForGrammarsParser.ParsingAtomContext)
                val oldParentFollow = parentFollowStack.pop()
                if (curFirst.contains("")) {
                    curFirst.addAll(oldParentFollow)
                }
                parentFollowStack.push(curFirst)
            }
        }
        parentFollowStack.pop()
        return null
    }

    override fun visitParsingAtom(ctx: GrammarForGrammarsParser.ParsingAtomContext?): Void? {
        if (ctx === null) {
            return null
        }
        if (ctx.childCount == 1) {
            addParentFollow(ctx.text)
        }
        return null
    }

    private fun addParentFollow(node: String) {
        //check that node non-terminal
        if (first.containsKey(node)) {
            if (follow.containsKey(node)) {
                follow[node]!!.addAll(parentFollowStack.peek())
            } else {
                follow[node] = parentFollowStack.peek().toMutableSet()
            }
        }
    }

    private fun firstByParsingAtom(ctx: GrammarForGrammarsParser.ParsingAtomContext): MutableSet<String> {
        var res: MutableSet<String> = HashSet()
        if (ctx.childCount == 1) {
            return first[ctx.text]?.toMutableSet() ?: mutableSetOf(ctx.text)
        }
        return res
    }

}