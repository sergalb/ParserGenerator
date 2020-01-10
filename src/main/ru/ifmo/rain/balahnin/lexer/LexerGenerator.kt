package ru.ifmo.rain.balahnin.lexer

import GrammarForGrammarsLexer
import GrammarForGrammarsParser
import Lexer
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

val tokensFileName = "TokensRegexps"
val lexerCode =
    "import java.io.File\n" +
            "import java.util.regex.PatternSyntaxException\n" +
            "import kotlin.text.Regex.Companion.escape\n" +
            "class Lexer(val input: String) {\n" +
            "    var cur = 0\n" +
            "    val regexps:MutableMap<String, Token> = HashMap()\n" +
            "    lateinit var whiteSpaces: List<Char>\n" +
            "    init {\n" +
            "        val tokensFile = File(\"${baseDir.replace("\\", "\\\\")}\\\\$tokensFileName\")\n" +
            "        for (line in tokensFile.readLines()) {\n" +
            "            val (identifier, value) = line.split(\" \")\n" +
            "\n" +
            "            if (identifier == \"skip\") {\n" +
            "                var ws = line.split(\"[\")[1]\n" +
            "                ws = ws.replace(\"\\\\t\", \"\\t\");\n" +
            "                ws = ws.replace(\"\\\\n\", \"\\n\");\n" +
            "                ws = ws.replace(\"\\\\r\", \"\\r\");\n" +
            "                whiteSpaces = ws.substring(0, ws.length - 1).toList()\n" +
            "            } else {\n" +
            "                regexps[\"\"\"\$value\"\"\"] = Token(identifier, null)\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "    fun scan(): List<Token> {\n" +
            "        val res:MutableList<Token> = ArrayList()\n" +
            "        while (cur < input.length) {\n" +
            "            var maxPref = 0\n" +
            "            var bestMatch: MatchResult? = null\n" +
            "            var bestToken: Token? = null\n" +
            "            var isPrefixWhitespace = false\n" +
            "            for (ws in whiteSpaces) {\n" +
            "                if (input[cur] == ws) {\n" +
            "                    cur++\n" +
            "                    isPrefixWhitespace = true\n" +
            "                    break\n" +
            "                }\n" +
            "            }\n" +
            "            if (isPrefixWhitespace) continue\n" +
            "\n" +
            "            for ((regexpString, token) in regexps) {\n" +
            "                var regexp : Regex =\n" +
            "                try {\n" +
            "                     Regex(\"\"\"\$regexpString\"\"\")\n" +
            "                } catch (e: PatternSyntaxException) {\n" +
            "                     Regex(escape(regexpString))\n" +
            "                }\n" +
            "                val match = regexp.find(input, cur)\n" +
            "                if (match !== null) {\n" +
            "                    if ((match.range.start == cur) && match.range.count() > maxPref) {\n" +
            "                        maxPref = match.range.count()\n" +
            "                        bestMatch = match\n" +
            "                        bestToken = Token(token)\n" +
            "                    }\n" +
            "                }\n" +
            "            }\n" +
            "            if (res.size >= 2 && res[1].value == \"doElse\") {\n" +
            "                print(\"a\")\n" +
            "            }\n" +
            "            if (bestMatch !== null) {\n" +
            "                cur += maxPref\n" +
            "                bestToken!!.value = bestMatch.value\n" +
            "                res.add(bestToken);\n" +
            "            } else {\n" +
            "                throw IllegalArgumentException(\"input file doesn't matches to given grammar\")\n" +
            "            }\n" +
            "        }\n" +
            "        return res\n" +
            "    }\n" +
            "\n" +
            "}\n" +
            "\n"
val tokenCode = "data class Token(val name: String, var value: String?) {\n" +
        "    constructor(other: Token) : this(other.name, other.value)\n" +
        "}"
fun main() {
    generateLexer()
    val inS = File("$baseDir\\Test")
    val inp = inS.readText()
    val lexer = Lexer(inp)
    val res = lexer.scan()
    print(res)
}

fun generateTokenRules() {
    val lexer = GrammarForGrammarsLexer(CharStreams.fromFileName("$baseDir\\Java.g4"))
    val parser = GrammarForGrammarsParser(CommonTokenStream(lexer))
    val tree = parser.grammar_()
    val outputStreamWriter = OutputStreamWriter(FileOutputStream("$baseDir\\$tokensFileName"))
    val visitor = LexerVisitor(outputStreamWriter)
    visitor.visitGrammar_(tree)
    outputStreamWriter.close()
}

fun generateLexer() {
    generateTokenRules()
    val tokenWriter = OutputStreamWriter(FileOutputStream("$baseDir\\Token.kt"))
    tokenWriter.write(tokenCode)
    tokenWriter.close()
    val lexerWriter = OutputStreamWriter(FileOutputStream("$baseDir\\Lexer.kt"))
    lexerWriter.write(lexerCode)
    lexerWriter.close()

}

