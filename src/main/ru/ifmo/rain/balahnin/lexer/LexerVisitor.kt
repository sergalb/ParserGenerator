package ru.ifmo.rain.balahnin.lexer

import GrammarForGrammarsBaseVisitor
import org.antlr.v4.runtime.tree.TerminalNode
import java.io.OutputStreamWriter
import java.lang.StringBuilder


class LexerVisitor (val outputStreamWriter: OutputStreamWriter) : GrammarForGrammarsBaseVisitor<StringBuilder>() {
    val rules : MutableMap<String, String> = HashMap()
    val LINE_SEPARATOR = System.lineSeparator()

    override fun visitGrammar_(ctx: GrammarForGrammarsParser.Grammar_Context): StringBuilder {
        super.visitGrammar_(ctx)
        var changed = true
        while (changed) {
            changed = false
            for ((k, v) in rules) {
                for ((innerK, innerV) in rules) {
                    if (v.contains(innerK)) {
                        rules[k] = v.replace(innerK, innerV)
                        changed = true
                    }
                }
            }
        }
        for ((k, v) in rules) {
            outputStreamWriter.write("$k $v$LINE_SEPARATOR")
        }
        if (ctx.getChild(ctx.childCount - 1) !is TerminalNode) {
            outputStreamWriter.write(ctx.getChild(ctx.childCount - 1).accept(this).toString())
        }
        return StringBuilder()
    }

    override fun visitSkipingCharacters(ctx: GrammarForGrammarsParser.SkipingCharactersContext?): StringBuilder {
        if (ctx === null) {
            return StringBuilder()
        }
        val res = StringBuilder()
        for (child in ctx.children) {
            if (child.text != ";") {
                if (child.text != ":") {
                    res.append(child.accept(this))
                } else res.append(" ")
            }
        }
        return res
    }

    override fun visitLexingRule(ctx: GrammarForGrammarsParser.LexingRuleContext?): StringBuilder {
        if (ctx == null)  {
            return StringBuilder()
        }
        val res = StringBuilder();
        for (child in ctx.children) {
            if (child !is TerminalNode) {
                res.append(child.accept(this))
            }
        }
        rules[ctx.getChild(0).text] = res.toString()
        return res
    }

    override fun visitLexingAtom(ctx: GrammarForGrammarsParser.LexingAtomContext?): StringBuilder {
        if (ctx == null)  {
            return StringBuilder()
        }
        val res = StringBuilder()
        for (child in ctx.children) {
            if (child !is TerminalNode) {
                val a = child.accept(this)
                res.append(child.accept(this))
            } else {
                val childText = child.text
                if (rules.containsKey(child.text)) {
                    res.append(rules[child.text])
                } else if (ctx.children.size == 1 && childText.startsWith("'")) {
                    res.append(childText.substring(1, childText.length - 1))
                } else {
                    res.append(childText)
                }
            }
        }
        return res
    }



    override fun visitFragmentRule(ctx: GrammarForGrammarsParser.FragmentRuleContext?): StringBuilder {
        if (ctx === null)  {
            return StringBuilder()
        }
        val res = StringBuilder();
        for (child in ctx.children) {
            if (child !is TerminalNode) {
                res.append(child.accept(this))
            }
        }
        rules[ctx.getChild(1).text] = res.toString()
        return res
    }

    override fun visitTerminal(node: TerminalNode?): StringBuilder {
        return StringBuilder(node?.text ?: "")
    }
}