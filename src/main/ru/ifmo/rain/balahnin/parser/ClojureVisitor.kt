package ru.ifmo.rain.balahnin.parser

import GrammarForGrammarsBaseVisitor


class ClojureVisitor(private val identifier: String): GrammarForGrammarsBaseVisitor<List<GrammarForGrammarsParser.ParsingRuleContext>>() {
    private val res: MutableList<GrammarForGrammarsParser.ParsingRuleContext> = ArrayList()
    override fun visitGrammar_(ctx: GrammarForGrammarsParser.Grammar_Context?): List<GrammarForGrammarsParser.ParsingRuleContext> {
        super.visitGrammar_(ctx)
        return res
    }
    override fun visitParsingRule(ctx: GrammarForGrammarsParser.ParsingRuleContext?): List<GrammarForGrammarsParser.ParsingRuleContext> {
        if (ctx === null) {
            return emptyList()
        }
        if (identifier == ctx.PARSER_IDENTIFIER().text) {
            res.add(ctx)
        }
        super.visitParsingRule(ctx)
        return emptyList()
    }
}