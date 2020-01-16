package ru.ifmo.rain.balahnin.parser

import ru.ifmo.rain.balahnin.*
import java.io.FileOutputStream
import java.io.OutputStreamWriter

val commonParserCode = "import GrammarForGrammarsLexer\n" +
        "import GrammarForGrammarsParser\n" +
        "import MyToken\n" +
        "import org.antlr.v4.runtime.CharStreams\n" +
        "import org.antlr.v4.runtime.CommonTokenStream\n" +
        "import ru.ifmo.rain.balahnin.alphabetFile\n" +
        "import ru.ifmo.rain.balahnin.baseDir\n" +
        "import ru.ifmo.rain.balahnin.grammarFile\n" +
        "import ru.ifmo.rain.balahnin.parser.IndexVisitor\n" +
        "import ru.ifmo.rain.balahnin.parser.RuleCollector\n" +
        "import ru.ifmo.rain.balahnin.tableFileName\n" +
        "import java.io.FileInputStream\n" +
        "import java.io.ObjectInputStream\n" +
        "import java.lang.IllegalStateException\n" +
        "import java.util.*\n" +
        "import kotlin.collections.ArrayList\n" +
        "\n" +
        "class Parser {\n" +
        "    private val table: List<MutableList<Pair<String, Int>>>\n" +
        "    private val alphabet: Map<String, Boolean>\n" +
        "    private var tokens: List<MyToken> = ArrayList()\n" +
        "    private val alphabetIndexed: Map<String, Int>\n" +
        "    private val tree: GrammarForGrammarsParser.Grammar_Context\n" +
        "    private val rules: MutableList<GrammarForGrammarsParser.ParsingRuleContext> = ArrayList()\n" +
        "    init {\n" +
        "        val tableInputStream = ObjectInputStream(FileInputStream(\"$baseDirForCodeGeneration\\\\$tableFileName\"))\n" +
        "        table = tableInputStream.readObject() as List<MutableList<Pair<String, Int>>>\n" +
        "        val alphabetInputStream = ObjectInputStream(FileInputStream(\"$baseDirForCodeGeneration\\\\$alphabetFile\"))\n" +
        "        alphabet = alphabetInputStream.readObject() as Map<String, Boolean>\n" +
        "        alphabetIndexed =\n" +
        "            alphabet.keys.mapIndexed { ind, value -> value to ind }\n" +
        "                .plus(Pair(\"\$\", alphabet.size)).toMap()\n" +
        "        val lexer = GrammarForGrammarsLexer(CharStreams.fromFileName(\"$baseDirForCodeGeneration\\\\$grammarFile\"))\n" +
        "        val parser = GrammarForGrammarsParser(CommonTokenStream(lexer))\n" +
        "        tree = parser.grammar_()\n" +
        "        IndexVisitor().visitGrammar_(tree)\n" +
        "        RuleCollector(rules).visitGrammar_(tree)\n" +
        "    }\n" +
        "\n" +
        "    fun parse(inpTokens: List<MyToken>): MyToken {\n" +
        "        this.tokens = inpTokens.asSequence().plusElement(MyToken(\"\$\", \"eof\")).toList()\n" +
        "        val stack = Stack<MyToken>()\n" +
        "        val stateIndexes = Stack<Int>()\n" +
        "        stateIndexes.push(0)\n" +
        "        var curState:Int\n" +
        "        var ind = 0\n" +
        "        var token = tokens[0]\n" +
        "        while (ind < tokens.size) {\n" +
        "            curState = stateIndexes.peek()\n" +
        "            val tokenInd = alphabetIndexed[token.name]!!\n" +
        "            val action = table[curState][tokenInd]\n" +
        "            when (action.first) {\n" +
        "                \"s\" -> {\n" +
        "                    stateIndexes.push(action.second)\n" +
        "                    stack.push(token)\n" +
        "                    token = tokens[++ind]\n" +
        "                }\n" +
        "                \"r\" -> {\n" +
        "                    val rule = rules[action.second]\n" +
        "                    val rightPart = rule.parsingAtom()\n" +
        "                    val right: MutableList<MyToken> = MutableList(rightPart.size) { MyToken(\"fake\", \"fake\") }\n" +
        "                    for (i in 0 until rightPart.size) {\n" +
        "                        right[rightPart.size - 1 - i] = stack.pop()!!\n" +
        "                        stateIndexes.pop()\n" +
        "                    }\n" +
        "                    val newTokenValue = attributeCalculation[action.second](right)\n" +
        "                    val newTokenName = rule.PARSER_IDENTIFIER().text\n" +
        "                    stack.push(MyToken(newTokenName, newTokenValue))\n" +
        "                    val prevState = stateIndexes.peek()\n" +
        "                    stateIndexes.push(table[prevState][alphabetIndexed[newTokenName]!!].second)\n" +
        "                }\n" +
        "                \"a\" -> return stack.peek()\n" +
        "                \"e\" -> throw IllegalStateException(\"exicuting table in wrong state (state index): \$curState, action: \$action\")\n" +
        "                else -> {\n" +
        "                    throw IllegalStateException(\"exicuting table in wrong state (state index): \$curState, action: \$action\")\n" +
        "                }\n" +
        "            }\n" +
        "        }\n" +
        "        error(\"acceptable state was not reached\")\n" +
        "    }\n" +
        "}\n"
private val atributeDeclaration = "val attributeCalculation: List<(List<MyToken>) -> String>"
fun generateParser(){
    val parserWriter = OutputStreamWriter(FileOutputStream("$baseDir\\Parser.kt"))
    parserWriter.write(commonParserCode)
    val tree = getGrammarContext()
    IndexVisitor().visitGrammar_(tree)
    val attributeCodes: MutableList<String> = ArrayList()
    AtributeCodeFinder(attributeCodes).visitGrammar_(tree)
    parserWriter.write("$atributeDeclaration = listOf(")
    for (ind in attributeCodes.indices) {
        parserWriter.write(attributeCodes[ind])
        if (ind < attributeCodes.size - 1) {
            parserWriter.write(",\n")
        }
    }
    parserWriter.write(")")
    parserWriter.close()
}