import kotlinx.coroutines.*

fun main() = runBlocking { 
    launch { 
        delay(1000L) 
        println("Hello from Coroutine!")
    }
    println("Hello from Main Thread!")
}