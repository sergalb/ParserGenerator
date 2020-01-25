package ru.ifmo.rain.balahnin

import GrammarForGrammarsLexer
import GrammarForGrammarsParser
import Lexer
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import ru.ifmo.rain.balahnin.lexer.generateLexer
import Parser
import ru.ifmo.rain.balahnin.parser.generateExecutingTable
import ru.ifmo.rain.balahnin.parser.generateParserFromTable
import java.io.File

val baseDir = "C:\\Users\\Sergalb\\Desktop\\ParserGenerator\\target\\generated-sources\\my"
val baseDirForCodeGeneration = baseDir.replace("\\", "\\\\")
lateinit var grammarFile:String
val tableFileName = "Table"
val alphabetFile = "Alphabet"

fun main() {
    generateParser("C:\\Users\\Sergalb\\Desktop\\ParserGenerator\\src\\test\\ru\\ifmo\\rain\\balahnin\\calculator\\Calculator.g4")
}

fun generateParser(grammarPath: String) {
    grammarFile = grammarPath
    generateLexer()
    generateExecutingTable()
    generateParserFromTable()
}


fun getGrammarContext(): GrammarForGrammarsParser.Grammar_Context {
    val lexer = GrammarForGrammarsLexer(CharStreams.fromFileName(grammarFile))
    val parser = GrammarForGrammarsParser(CommonTokenStream(lexer))
    return parser.grammar_()
}