fun hof(str: String, mycall: (String) -> Unit) {
    mycall(str)
}
fun main() {
    println("Result: ")
    hof("Aaryan", ::println)
}