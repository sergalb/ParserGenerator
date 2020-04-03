import GrammarForGrammarsLexer
import GrammarForGrammarsParser
import MyToken
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import ru.ifmo.rain.balahnin.alphabetFile
import ru.ifmo.rain.balahnin.baseDir
import ru.ifmo.rain.balahnin.grammarFile
import ru.ifmo.rain.balahnin.parser.IndexVisitor
import ru.ifmo.rain.balahnin.parser.RuleCollector
import ru.ifmo.rain.balahnin.tableFileName
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.lang.IllegalStateException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.*

class Parser {
    private val table: List<MutableList<Pair<String, Int>>>
    private val alphabet: Map<String, Boolean>
    private var tokens: List<MyToken> = ArrayList()
    private val alphabetIndexed: Map<String, Int>
    private val tree: GrammarForGrammarsParser.Grammar_Context
    private val rules: MutableList<GrammarForGrammarsParser.ParsingRuleContext> = ArrayList()
    init {
        val tableInputStream = ObjectInputStream(FileInputStream("C:\\Users\\Sergalb\\Desktop\\ParserGenerator\\target\\generated-sources\\my\\Table"))
        table = tableInputStream.readObject() as List<MutableList<Pair<String, Int>>>
        val alphabetInputStream = ObjectInputStream(FileInputStream("C:\\Users\\Sergalb\\Desktop\\ParserGenerator\\target\\generated-sources\\my\\Alphabet"))
        alphabet = alphabetInputStream.readObject() as Map<String, Boolean>
        alphabetIndexed =
            alphabet.keys.mapIndexed { ind, value -> value to ind }
                .plus(Pair("$", alphabet.size)).toMap()
        val lexer = GrammarForGrammarsLexer(CharStreams.fromFileName("C:\\Users\\Sergalb\\Desktop\\ParserGenerator\\src\\test\\ru\\ifmo\\rain\\balahnin\\calculator\\Calculator.g4"))
        val parser = GrammarForGrammarsParser(CommonTokenStream(lexer))
        tree = parser.grammar_()
        IndexVisitor().visitGrammar_(tree)
        RuleCollector(rules).visitGrammar_(tree)
    }

    fun parse(inpTokens: List<MyToken>): MyToken {
        this.tokens = inpTokens.asSequence().plusElement(MyToken("$", "eof")).toList()
        val stack = Stack<MyToken>()
        val stateIndexes = Stack<Int>()
        stateIndexes.push(0)
        var curState:Int
        var ind = 0
        var token = tokens[0]
        while (ind < tokens.size) {
            curState = stateIndexes.peek()
            val tokenInd = alphabetIndexed[token.name]!!
            val action = table[curState][tokenInd]
            when (action.first) {
                "s" -> {
                    stateIndexes.push(action.second)
                    stack.push(token)
                    token = tokens[++ind]
                }
                "r" -> {
                    val rule = rules[action.second]
                    val rightPart = rule.parsingAtom()
                    val right: MutableList<MyToken> = MutableList(rightPart.size) { MyToken("fake", "fake") }
                    for (i in 0 until rightPart.size) {
                        right[rightPart.size - 1 - i] = stack.pop()!!
                        stateIndexes.pop()
                    }
                    val newTokenValue = attributeCalculation[action.second](right)
                    val newTokenName = rule.PARSER_IDENTIFIER().text
                    stack.push(MyToken(newTokenName, newTokenValue, right))
                    val prevState = stateIndexes.peek()
                    stateIndexes.push(table[prevState][alphabetIndexed[newTokenName]!!].second)
                }
                "a" -> return stack.peek()
                "e" -> throw IllegalStateException("exicuting table in wrong state (state index): $curState, action: $action")
                else -> {
                    throw IllegalStateException("exicuting table in wrong state (state index): $curState, action: $action")
                }
            }
        }
        error("acceptable state was not reached")
    }
}
val attributeCalculation: List<(List<MyToken>) -> String> = listOf({ it -> it[0].value },
{it -> (it[0].value.toDouble() + it[2].value.toDouble()).toString()},
{it -> (it[0].value.toDouble() - it[2].value.toDouble()).toString()},
{ it -> it[0].value },
{it -> (it[0].value.toDouble() * it[2].value.toDouble()).toString()},
{it -> (it[0].value.toDouble() / it[2].value.toDouble()).toString()},
{ it -> it[0].value },
{it -> (it[0].value.toDouble().pow(it[2].value.toDouble()).toString())},
{ it -> it[0].value },
{it -> it[1].value},
{ it -> (-it[1].value.toDouble()).toString()},
{ it -> it[0].value })