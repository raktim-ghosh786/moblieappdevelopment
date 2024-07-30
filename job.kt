import kotlinx.coroutines.*

fun main() = runBlocking {
    val parentJob = launch {
        val childJob = launch {
            while (true) {
                println("Child is running")
                delay(1000L)
            }
        }
        delay(2000L)
        println("Cancelling child job")
        childJob.cancel()
    }
    parentJob.join()
}