package ru.ifmo.rain.balahnin.parser

//val states: MutableList<AutomatonNode> = ArrayList()
//val table: List<MutableList<String>> =
//    List(countStates) {
//        MutableList(alphabet.size + 1) { "   " }
//    }
//val orderedAlphabet = alphabet.map { it.key }.toList()
//val alphabetIndexed =
//    alphabet.keys.mapIndexed { ind, value -> value to ind }
//        .plus(Pair("$", alphabet.size)).toMap()

fun main() {
    createTable(root, MutableList(countStates) {false})
//    for (ind in table.indices) {
//        println("$ind ${table[ind].joinToString(separator = " ") { it  }}")
//    }
}

//fun createTable(node: AutomatonNode, was: MutableList<Boolean>) {
//    if (was[node.ind]) {
//        return
//    }
//    for (rule in node.rules) {
//        val rightPart = rule.rule.parsingAtom()
//        if (rule.position < rightPart.size) {
//            val shiftSymbol = rightPart[rule.position].text
//            table[node.ind][alphabetIndexed[shiftSymbol]!!] = "s ${node.ind}"
//        } else {
//            assert(node.ind != 0 || node.ind == 0 && rule.lookahead == mutableSetOf("$"))
//            if (node.ind == 0 && rule.lookahead == mutableSetOf("$")) {
//                table[node.ind][alphabetIndexed["$"]!!] = "acc"
//            } else {
//                for (lookaheadSymbol in rule.lookahead) {
//                    table[node.ind][alphabetIndexed[lookaheadSymbol]!!] = "r ${rule.rule.ruleIndex}"
//                }
//            }
//        }
//    }
//    for ((_, next) in node.transitions) {
//        createTable(next, was)
//    }
//}

