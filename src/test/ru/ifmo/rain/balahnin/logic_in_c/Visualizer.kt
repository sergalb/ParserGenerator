package ru.ifmo.rain.balahnin.logic_in_c

import Lexer
import MyToken
import Parser
import ru.ifmo.rain.balahnin.generateParser
import kotlin.test.assertEquals


private val STEP = 7
fun printTree(expression: MyToken, depth: Int = 0) {
    if (expression.children.size == 0) {
        println((" ".repeat(STEP - 1) + "|").repeat(depth)  + "${expression.name}: ${expression.value}")
        return
    }

    println((" ".repeat(STEP - 1) + "|").repeat(depth) + "${expression.name}: ${expression.value}->")
    for (child in expression.children) {
        printTree(child, depth + 1)
    }
}

fun main() {
    generateParser("C:\\Users\\Sergalb\\Desktop\\ParserGenerator\\src\\test\\ru\\ifmo\\rain\\balahnin\\logic_in_c\\Logic.g4")
    val lexer = Lexer("1|2 & !!3 ^ 4")
    val res = lexer.scan()
    val parser = Parser()
    val rootToken = parser.parse(res)
    printTree(rootToken)
}