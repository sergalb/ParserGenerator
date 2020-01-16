package ru.ifmo.rain.balahnin.parser

import GrammarForGrammarsBaseVisitor

class AtributeCodeFinder(val attributeCodes: MutableList<String>) : GrammarForGrammarsBaseVisitor<Void?>() {
    override fun visitParsingRule(ctx: GrammarForGrammarsParser.ParsingRuleContext?): Void? {
        if (ctx === null) {
            return null
        }
        attributeCodes.add(
            if (ctx.CodeLiteral() !== null) {
                ctx.CodeLiteral().text
            } else {
                "{ it -> it[0].value }"
            }
        )
        return super.visitParsingRule(ctx)
    }
}
