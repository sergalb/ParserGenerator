package ru.ifmo.rain.balahnin.calculator

import Lexer
import Parser
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import ru.ifmo.rain.balahnin.generateParser
import java.util.*
import kotlin.math.abs
import kotlin.test.assertEquals


class CalculatorTester {

    companion object {
        @BeforeAll
        @JvmStatic
        fun generateParserForCalculatorGrammar() {
            generateParser("C:\\Users\\Sergalb\\Desktop\\ParserGenerator\\src\\test\\ru\\ifmo\\rain\\balahnin\\calculator\\Calculator.g4")
        }
    }
    @Test
    fun work(){
        assert(true)
    }
    @Test
    fun parseOne() {
        val lexer = Lexer("1")
        val res = lexer.scan()
        val parser = Parser()
        val rootToken = parser.parse(res)
        assertEquals(1.0, rootToken.value.toDouble())
    }

    @Test
    fun parseOnePlusTwo() {
        val lexer = Lexer("1 + 2")
        val res = lexer.scan()
        val parser = Parser()
        val rootToken = parser.parse(res)
        assertEquals(3.0, rootToken.value.toDouble())
    }

    @Test
    fun twoPlusTwoMultiplyTwo() {
        val lexer = Lexer("2 + 2 * 2")
        val res = lexer.scan()
        val parser = Parser()
        val rootToken = parser.parse(res)
        assertEquals(6.0, rootToken.value.toDouble())
    }

    @Test
    fun twoPlusTwoMultiplyTwoWithBrackets() {
        val lexer = Lexer("(2+2)*2")
        val res = lexer.scan()
        val parser = Parser()
        val rootToken = parser.parse(res)
        assertEquals(8.0, rootToken.value.toDouble())
    }

    @Test
    fun fourteenDivideTwoMinusOne() {
        val lexer = Lexer("14/2-1")
        val res = lexer.scan()
        val parser = Parser()
        val rootToken = parser.parse(res)
        assertEquals(6.0, rootToken.value.toDouble())
    }

    @Test
    fun bigExpression() {
        val lexer = Lexer("645-9498*648/52*644/25+48494-9+8962+8495/15*45815-256*256-94984-1523412315")
        val res = lexer.scan()
        val parser = Parser()
        val rootToken = parser.parse(res)
        val EPS = 1e1
        println(rootToken.value.toDouble())
        assert( abs(rootToken.value.toDouble() - -1.5006171270071795E9) < EPS)
    }

    @Test
    fun unaryMinus() {
        val lexer = Lexer("-1")
        val res = lexer.scan()
        val parser = Parser()
        val rootToken = parser.parse(res)
        assertEquals(-1.0, rootToken.value.toDouble())
    }

    @Test
    fun power() {
        val lexer = Lexer("2^3^2")
        val res = lexer.scan()
        val parser = Parser()
        val rootToken = parser.parse(res)
        assertEquals(512.0, rootToken.value.toDouble())
    }
}