import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        val result = async { 
            computeResult() 
        }
        println("Computed result: ${result.await()}")
    }
    Thread.sleep(2000L)
}

suspend fun computeResult(): Int {
    delay(1000L)
    return 42
}