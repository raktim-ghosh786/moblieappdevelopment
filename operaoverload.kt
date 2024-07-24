class Object(var objName: String) {
    // overloading the func
    operator fun plus(b: Int) {
        objName = "Name is $objName and data is $b"
    }
    override fun toString(): String {
        return objName
    }
}
fun main() {
    val obj = Object("Aaryan")
    obj+10
    println(obj)
}