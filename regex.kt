fun main() {
    val pattern = Regex("ll") // match ll
    val res : MatchResult? = pattern.find("Hello Hello", 5)
    println(res?.value)

}