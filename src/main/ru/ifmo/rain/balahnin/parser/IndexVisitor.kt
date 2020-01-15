package ru.ifmo.rain.balahnin.parser

import GrammarForGrammarsBaseVisitor

class IndexVisitor(): GrammarForGrammarsBaseVisitor<Void?>() {
    private var ind = 0
    override fun visitParsingRule(ctx: GrammarForGrammarsParser.ParsingRuleContext?): Void? {
        if (ctx === null) {
            return null
        }
        ctx.altNum = ind++
        return super.visitParsingRule(ctx)
    }

    override fun visitParsingAtom(ctx: GrammarForGrammarsParser.ParsingAtomContext?): Void? {
        if (ctx === null) {
            return null
        }
        ctx.altNum = ind
        return super.visitParsingAtom(ctx)
    }
}