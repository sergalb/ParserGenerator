package ru.ifmo.rain.balahnin.parser

import GrammarForGrammarsBaseVisitor

class RuleCollector(val rules: MutableList<GrammarForGrammarsParser.ParsingRuleContext>
): GrammarForGrammarsBaseVisitor<Void?>() {
    override fun visitParsingRule(ctx: GrammarForGrammarsParser.ParsingRuleContext?): Void? {
        if (ctx === null) {
            return null
        }
        rules.add(ctx)
        return super.visitParsingRule(ctx)
    }
}