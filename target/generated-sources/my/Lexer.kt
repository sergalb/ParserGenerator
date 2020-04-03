import java.io.File
import java.util.regex.PatternSyntaxException
import kotlin.text.Regex.Companion.escape
class Lexer(val input: String) {
    var cur = 0
    val regexps:MutableMap<String, MyToken> = HashMap()
    lateinit var whiteSpaces: List<Char>
    init {
        val tokensFile = File("C:\\Users\\Sergalb\\Desktop\\ParserGenerator\\target\\generated-sources\\my\\TokensRegexps")
        for (line in tokensFile.readLines()) {
            val (identifier, value) = line.split(" ")

            if (identifier == "skip") {
                var ws = line.split("[")[1]
                ws = ws.replace("\\t", "\t");
                ws = ws.replace("\\n", "\n");
                ws = ws.replace("\\r", "\r");
                whiteSpaces = ws.substring(0, ws.length - 1).toList()
            } else {
                regexps["""$value"""] = MyToken(identifier, "fake")
            }
        }
    }
    fun scan(): List<MyToken> {
        val res:MutableList<MyToken> = ArrayList()
        while (cur < input.length) {
            var maxPref = 0
            var bestMatch: MatchResult? = null
            var bestToken: MyToken? = null
            var isPrefixWhitespace = false
            for (ws in whiteSpaces) {
                if (input[cur] == ws) {
                    cur++
                    isPrefixWhitespace = true
                    break
                }
            }
            if (isPrefixWhitespace) continue

            for ((regexpString, token) in regexps) {
                var regexp : Regex =
                try {
                     Regex(regexpString)
                } catch (e: PatternSyntaxException) {
                     Regex(escape(regexpString))
                }
                val match = regexp.find(input, cur)
                if (match !== null) {
                    if ((match.range.start == cur) && match.range.count() > maxPref) {
                        maxPref = match.range.count()
                        bestMatch = match
                        bestToken = MyToken(token)
                    }
                }
            }
            if (bestMatch !== null) {
                cur += maxPref
                bestToken!!.value = bestMatch.value
                res.add(bestToken);
            } else {
                throw IllegalArgumentException("input file doesn't matches to given grammar")
            }
        }
        return res
    }

}

