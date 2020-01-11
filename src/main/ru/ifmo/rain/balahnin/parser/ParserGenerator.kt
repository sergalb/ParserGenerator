package ru.ifmo.rain.balahnin.parser

import GrammarForGrammarsLexer
import GrammarForGrammarsParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import ru.ifmo.rain.balahnin.lexer.baseDir
import ru.ifmo.rain.balahnin.lexer.grammarFile


val first :MutableMap<String, MutableSet<String>> = LinkedHashMap()
val follow :MutableMap<String, MutableSet<String>> = LinkedHashMap()
fun main() {
    val lexer = GrammarForGrammarsLexer(CharStreams.fromFileName("$baseDir\\$grammarFile"))
    val parser = GrammarForGrammarsParser(CommonTokenStream(lexer))
    val tree = parser.grammar_()
    generateFirst(tree)
    generateFollow(tree)
}

fun generateFirst(grammarContext: GrammarForGrammarsParser.Grammar_Context) {
    val visitor = FirstGeneratorVisitor(first)
    visitor.visitGrammar_(grammarContext)
}

fun generateFollow(grammarContext: GrammarForGrammarsParser.Grammar_Context) {
    follow["file"] = mutableSetOf("$")
    val visitor = FollowGeneratorVisitor(first, follow)
    visitor.visitGrammar_(grammarContext)
}