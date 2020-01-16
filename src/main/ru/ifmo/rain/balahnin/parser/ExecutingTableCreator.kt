package ru.ifmo.rain.balahnin.parser

import GrammarForGrammarsLexer
import GrammarForGrammarsParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import ru.ifmo.rain.balahnin.*
import java.io.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap


val first: MutableMap<String, MutableSet<String>> = LinkedHashMap()
//val follow: MutableMap<String, MutableSet<String>> = LinkedHashMap()
//grammarSymbol name and isTerminal
var alphabet: Map<String, Boolean> = HashMap()
var countStates = 0
lateinit var root: AutomatonNode

lateinit var table: List<MutableList<Pair<String, Int>>>
lateinit var alphabetIndexed: Map<String, Int>
var realCount = 0

data class Rule(
    val rule: GrammarForGrammarsParser.ParsingRuleContext,
    var position: Int,
    val lookahead: MutableSet<String>
) {
    override fun toString(): String {
        return "${rule.text} $position $lookahead"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Rule) {
            return false
        }
        return position == other.position && rule.text == other.rule.text
    }

    override fun hashCode(): Int {
        return "${rule.text} $position".hashCode()
    }
}

class AutomatonNode(var creationInd: Int, val rules: List<Rule>, var parent: AutomatonNode?, var parentVersion: Int) {
    val transitions: MutableMap<String, AutomatonNode> = HashMap()
    override fun toString(): String {
        return rules.toString()
    }

    var ind = 0
    var version = 0
}

fun generateExecutingTable() {
    val tree = getGrammarContext()
    generateFirst(tree)
    generateExecutingAutomaton(tree)
    IndexVisitor().visitGrammar_(tree)

    countAutomatSize(root)
    table = List(realCount) {
        MutableList(alphabet.size + 1) { Pair("e", 0) }
    }
    alphabetIndexed =
        alphabet.keys.mapIndexed { ind, value -> value to ind }
            .plus(Pair("$", alphabet.size)).toMap()
    createTable(root)
    val objectOutputStream = ObjectOutputStream(FileOutputStream("$baseDir\\$tableFileName"))
    objectOutputStream.writeObject(table)
    objectOutputStream.close()
    val oos = ObjectOutputStream(FileOutputStream("$baseDir\\$alphabetFile"))
    oos.writeObject(alphabet)
    oos.close()

}

fun generateFirst(grammarContext: GrammarForGrammarsParser.Grammar_Context) {
    val visitor = FirstGeneratorVisitor(first)
    visitor.visitGrammar_(grammarContext)
}

fun generateExecutingAutomaton(grammarContext: GrammarForGrammarsParser.Grammar_Context) {
    alphabet = AlphabetVisitor().visit(grammarContext)
    val startRule = closure(Rule(grammarContext.parsingRule(0), 0, mutableSetOf("$")), grammarContext)
    root = AutomatonNode(countStates++, startRule, null, 0)
    val stack: MutableList<AutomatonNode> = LinkedList()
    stack.add(root)
    while (stack.isNotEmpty()) {
        val curNode = stack.removeAt(0)
        val vertexesForAdding: MutableList<Pair<AutomatonNode, String>> = ArrayList()
        var hasLoop = false
        for ((symbol, _) in alphabet) {
            val newNodeRules = goto(curNode, symbol, grammarContext)
            val existingNode = findNode(root, newNodeRules)
            if (existingNode != null) {
                if (!include(existingNode.rules, newNodeRules)) {
                    if (existingNode.creationInd == curNode.creationInd) {
                        hasLoop = true
                    } else {
                        vertexesForAdding.add(Pair(existingNode, symbol))
                    }
                    for (i in existingNode.rules.indices) {
                        assert(existingNode.rules[i] == newNodeRules[i])
                        existingNode.rules[i].lookahead.addAll(newNodeRules[i].lookahead)
                    }
                }
                curNode.transitions[symbol] = existingNode
            } else if (newNodeRules.isNotEmpty()) {
                vertexesForAdding.add(
                    Pair(
                        AutomatonNode(countStates++, newNodeRules, curNode, curNode.version),
                        symbol
                    )
                )
            }
        }
        if (!hasLoop) {
            for ((newNode, symbol) in vertexesForAdding) {
                curNode.transitions[symbol] = newNode
                stack.add(newNode)
            }
        } else {
            stack.add(curNode)
        }
    }
}

fun closure(rules: Rule, grammarContext: GrammarForGrammarsParser.Grammar_Context): List<Rule> {
    val res = mutableListOf(rules)
    var changed = true
    //val lookahead = rules.lookahead
    while (changed) {
        changed = false
        for ((rule, position, lookahead) in res) {
            val rightPart = rule.parsingAtom()
            if (position >= rightPart.size) {
                continue
            }
            val leftPartOfNewRule = rightPart[position].text
            //first is non-terminal
            if (!(alphabet[leftPartOfNewRule]!!)) {
                val newRules = ClojureVisitor(leftPartOfNewRule).visit(grammarContext)
                val newLookahead =
                    if (position + 1 < rightPart.size) {
                        val symbolAfterNew = rightPart[position + 1].text
                        if (alphabet[symbolAfterNew]!!) {
                            mutableSetOf(symbolAfterNew)
                        } else {
                            first(rightPart, position + 1, lookahead).toMutableSet()
                        }
                    } else {
                        lookahead.toMutableSet()
                    }
                val nr = newRules.map { Rule(it, 0, newLookahead) }.distinct()
                for (n in nr) {
                    val indN = res.indexOf(n)
                    if (indN != -1) {
                        if (!res[indN].lookahead.containsAll(n.lookahead)) {
                            res[indN].lookahead.addAll(n.lookahead)
                            changed = true
                        }
                    } else {
                        res.add(n)
                        changed = true
                    }
                }
                //res.addAll(newRules.map { Rule(it, 0, look) }.distinct())
                //curRuleStarts.add(leftPartOfNewRule)
                if (changed) break
            }
        }
    }
    return res
}

fun goto(node: AutomatonNode, symbol: String, grammarContext: GrammarForGrammarsParser.Grammar_Context): List<Rule> {
    val newNodeRules: MutableList<Rule> = ArrayList()
    for ((rule, position, lookahead) in node.rules) {
        val rightPart = rule.parsingAtom()
        if (position >= rightPart.size) {
            continue
        }
        if (symbol == rightPart[position].text) {
            //need copy of lookahead
            newNodeRules.addAll(closure(Rule(rule, position + 1, lookahead.toMutableSet()), grammarContext))
        }
    }
    if (newNodeRules.distinct() != newNodeRules) {
        println("raw")
        for (r in newNodeRules) {
            println(r)
        }
        println("distinct")
        for (r in newNodeRules.distinct()) {
            println(r)
        }
    }
    return newNodeRules.distinct()
}

private fun first(
    rightPart: List<GrammarForGrammarsParser.ParsingAtomContext>,
    start: Int,
    lookahead: Set<String>
): Set<String> {
    val res: MutableSet<String> = HashSet()
    for (i in start until rightPart.size) {
        val symbol = rightPart[i]
        if (alphabet[symbol.text]!!) {
            return setOf(symbol.text)
        } else {
            res.addAll(first[symbol.text]!!)
        }
        if (!res.contains("")) {
            return res
        }
    }
    res.addAll(lookahead)
    return res
}

private fun include(first: List<Rule>, second: List<Rule>): Boolean {
    if (first.size != second.size) {
        return false
    }
    for (ind in first.indices) {
        val fRule = first[ind]
        val sRule = second[ind]
        if (fRule.position != sRule.position || !fRule.lookahead.containsAll(sRule.lookahead) || fRule.rule.text != sRule.rule.text) {
            return false
        }
    }
    return true
}

private fun findNode(
    node: AutomatonNode,
    rules: List<Rule>,
    was: MutableList<Boolean> = MutableList(countStates) { false }
): AutomatonNode? {
    if (was[node.creationInd]) {
        return null
    }
    was[node.creationInd] = true
    if (node.rules == rules) {
        return node
    }
    for ((_, transition) in node.transitions) {
        val res = findNode(transition, rules, was)
        if (res !== null) {
            return res
        }
    }
    return null
}

//for debug
private fun printAutomaton(node: AutomatonNode, was: MutableList<Boolean> = MutableList(countStates) { false }) {
    if (was[node.creationInd]) {
        return
    }
    was[node.creationInd] = true
    println("$node\n")
    for ((_, transition) in node.transitions) {
        printAutomaton(transition, was)
    }
    return
}

fun createTable(node: AutomatonNode, was: MutableList<Boolean> = MutableList(countStates) { false }) {
    if (was[node.ind]) {
        return
    }
    was[node.ind] = true
    for (rule in node.rules) {
        val rightPart = rule.rule.parsingAtom()
        if (rule.position < rightPart.size) {
            val shiftSymbol = rightPart[rule.position].text
            table[node.ind][alphabetIndexed[shiftSymbol]!!] = Pair("s", node.transitions[shiftSymbol]!!.ind)
        } else {
            //assert(node.ind != 0 || node.ind == 0 && rule.lookahead == mutableSetOf("$"))
            if (node.ind != 0 && rule.rule.PARSER_IDENTIFIER().text == "start" && rightPart.size == 1 && rule.lookahead == mutableSetOf(
                    "$"
                )
            ) {
                table[node.ind][alphabetIndexed["$"]!!] = Pair("a", 0)
            } else {
                for (lookaheadSymbol in rule.lookahead) {
                    table[node.ind][alphabetIndexed[lookaheadSymbol]!!] = Pair("r", rule.rule.altNum)
                }
            }
        }
    }
    for ((_, next) in node.transitions) {
        createTable(next, was)
    }
}


private fun countAutomatSize(node: AutomatonNode, was: MutableList<Boolean> = MutableList(countStates) { false }) {
    if (was[node.creationInd]) {
        return
    }
    node.ind = realCount++
    was[node.creationInd] = true
    for ((_, transition) in node.transitions) {
        countAutomatSize(transition, was)
    }
}