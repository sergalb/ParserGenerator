package ru.ifmo.rain.balahnin.parser

import GrammarForGrammarsBaseVisitor

class AlphabetVisitor() : GrammarForGrammarsBaseVisitor<Map<String, Boolean>>() {
    val alphabet: MutableMap<String, Boolean> = HashMap()
    override fun visitGrammar_(ctx: GrammarForGrammarsParser.Grammar_Context?): Map<String, Boolean> {
        super.visitGrammar_(ctx)
        return alphabet
    }
    override fun visitParsingRule(ctx: GrammarForGrammarsParser.ParsingRuleContext?): Map<String, Boolean> {
        if (ctx === null){
            return emptyMap()
        }
        alphabet[ctx.PARSER_IDENTIFIER().text] = false
        super.visitParsingRule(ctx)
        return emptyMap()
    }

    override fun visitLexingRule(ctx: GrammarForGrammarsParser.LexingRuleContext?): Map<String, Boolean> {
        if (ctx === null){
            return emptyMap()
        }
        alphabet[ctx.LEXER_IDENTIFIER().text] = true
        super.visitLexingRule(ctx)
        return emptyMap()
    }
}