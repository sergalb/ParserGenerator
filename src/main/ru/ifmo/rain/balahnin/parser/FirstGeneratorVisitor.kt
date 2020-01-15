package ru.ifmo.rain.balahnin.parser

import GrammarForGrammarsBaseVisitor
import org.antlr.v4.runtime.tree.TerminalNode

class FirstGeneratorVisitor(val first: MutableMap<String, MutableSet<String>> = HashMap()) : GrammarForGrammarsBaseVisitor<Set<String>>() {

    override fun visitGrammar_(ctx: GrammarForGrammarsParser.Grammar_Context): Set<String> {
        super.visitGrammar_(ctx)
        var changed = true
        while (changed) {
            changed = false
            for ((k, v) in first) {
                for ((innerK, innerV) in first) {
                    if (v.contains(innerK)) {
                        v.remove(innerK)
                        v.addAll(innerV)
                        changed = true
                    }
                }
            }
        }
        return emptySet()
    }

    override fun visitParsingRule(ctx: GrammarForGrammarsParser.ParsingRuleContext?): Set<String> {
        if (ctx === null) {
            return emptySet()
        }
        val res: MutableSet<String> = HashSet()
        for (child in ctx.children) {
            if (child !is TerminalNode) {
                val childFirst = child.accept(this)
                res.addAll(childFirst)
                if (!childFirst.contains("")) {
                    break
                }
            }
        }
        if (ctx.childCount == 3) {
            res.add("")
        }
        val identifier = ctx.PARSER_IDENTIFIER().text
        if (first.containsKey(identifier)) {
            first[identifier]!!.addAll(res)
        } else {
            first[identifier] =  res
        }
        return res
    }

    override fun visitParsingAtom(ctx: GrammarForGrammarsParser.ParsingAtomContext?): Set<String> {
        if (ctx === null) {
            return emptySet()
        }
        return setOf(ctx.text)
    }

}