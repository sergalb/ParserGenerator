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
        /*if (ctx.PARSER_IDENTIFIER().text == "value") {
            print("a")
        }*/
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
        val res: MutableSet<String> = HashSet()
        if (ctx.childCount == 1) {
            return setOf(ctx.text)
        }
//        if (ctx.childCount == 2) {
//            res.addAll(ctx.getChild(0).accept(this))
//            val operator = ctx.getChild(1).text
//            if (operator == "?" || operator == "*") {
//                res.add("")
//            }
//            return res
//        }
//        // A -> B | C
//        if (ctx.childCount == 3 && ctx.getChild(1).text == "|") {
//            res.addAll(ctx.getChild(0).accept(this))
//            res.addAll(ctx.getChild(2).accept(this))
//            return res
//        }
//        var hasEmpty = true
//        for (child in ctx.children) {
//            if (child !is TerminalNode) {
//                val childFirst = child.accept(this)
//                res.addAll(childFirst)
//                res.remove("")
//                if (!childFirst.contains("")) {
//                    hasEmpty = false
//                    break
//                }
//            }
//        }
//        if (hasEmpty) {
//            res.add("")
//        }
        return res
    }

}