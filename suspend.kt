import kotlinx.coroutines.*

suspend fun doSomething() {
    delay(1000L)
    println("Doing something")
}

fun main() = runBlocking {
    launch {
        doSomething()
    }
}