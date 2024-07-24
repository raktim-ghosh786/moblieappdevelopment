class RefDemo {
    
}
 
 
fun main() {
    val abc = RefDemo::class
    println("$abc")
    val obj = RefDemo()
    println("${obj::class}")
}