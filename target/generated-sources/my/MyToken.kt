data class MyToken(val name: String, var value: String, val children: MutableList<MyToken> = ArrayList()) {
    constructor(other: MyToken) : this(other.name, other.value)
}