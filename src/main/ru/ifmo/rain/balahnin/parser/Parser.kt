package ru.ifmo.rain.balahnin.parser

import MyToken
import ru.ifmo.rain.balahnin.baseDir
import ru.ifmo.rain.balahnin.tableFileName
import java.io.FileInputStream
import java.io.ObjectInputStream

class Parser {
    private val table: List<MutableList<Pair<String, Int>>>
    private val alphabet: Map<String, Boolean>
    private var tokens: List<MyToken> =  ArrayList()
    init {
        val tableInputStream = ObjectInputStream(FileInputStream("$baseDir\\$tableFileName"))
        table = tableInputStream.readObject() as List<MutableList<Pair<String, Int>>>
        val alphabetInputStream = ObjectInputStream(FileInputStream("$baseDir\\$tableFileName"))
        alphabet = alphabetInputStream.readObject() as Map<String, Boolean>
    }
    fun parse(tokens: List<MyToken>) {
        this.tokens = tokens

    }
}