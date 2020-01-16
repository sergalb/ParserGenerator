package ru.ifmo.rain.balahnin

import GrammarForGrammarsLexer
import GrammarForGrammarsParser
import Lexer
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import ru.ifmo.rain.balahnin.lexer.generateLexer
import Parser
import ru.ifmo.rain.balahnin.parser.generateExecutingTable
import ru.ifmo.rain.balahnin.parser.generateParser
import java.io.File

val baseDir = "C:\\Users\\Sergalb\\Desktop\\ParserGenerator\\target\\generated-sources\\my"
val baseDirForCodeGeneration = baseDir.replace("\\", "\\\\")
val grammarFile = "Calculator.g4"
val tableFileName = "Table"
val alphabetFile = "Alphabet"
var inputFile = "CalculatorTest"

fun main() {
    generateLexer()
    val inS = File("$baseDir\\$inputFile")
    val inp = inS.readText()
    val lexer = Lexer(inp)
    val res = lexer.scan()
    generateExecutingTable()
    generateParser()
    val parser = Parser()
    val rootToken = parser.parse(res)
    println(rootToken.value)
}

fun getGrammarContext(): GrammarForGrammarsParser.Grammar_Context {
    val lexer = GrammarForGrammarsLexer(CharStreams.fromFileName("$baseDir\\$grammarFile"))
    val parser = GrammarForGrammarsParser(CommonTokenStream(lexer))
    return parser.grammar_()
}