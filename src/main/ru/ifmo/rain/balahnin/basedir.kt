package ru.ifmo.rain.balahnin

import Lexer
import ru.ifmo.rain.balahnin.lexer.generateLexer
import ru.ifmo.rain.balahnin.parser.Parser
import ru.ifmo.rain.balahnin.parser.generateExecutingTable
import java.io.File

val baseDir = "C:\\Users\\Sergalb\\Desktop\\ParserGenerator\\target\\generated-sources\\my"
val grammarFile = "Calculator.g4"
val tableFileName = "Table"
val alphabetFile = "Alphabet"
var inputFile = "CalculatorTest"

fun main() {
    generateLexer()
    val inS = File("$baseDir\\CalculatorTest")
    val inp = inS.readText()
    val lexer = Lexer(inp)
    val res = lexer.scan()
    generateExecutingTable()
    val parser = Parser()
    val rootToken = parser.parse(res)
    println(rootToken.value)
}