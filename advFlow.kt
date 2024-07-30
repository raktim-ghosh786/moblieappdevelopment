import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun performRequest(request: Int): String {
    delay(1000L) 
    return "response $request"
}

fun main() = runBlocking {
    val flow = (1..5).asFlow().onEach { delay(300L) }
    flow.debounce(500L)
        .map { request -> performRequest(request) }
        .collect { response -> println(response) }
}