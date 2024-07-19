data class Event(
    val name: String,
    val date: String,
    val attendeeCount: Int
)

fun main(){
    println("Enter Event Name:")
    val name = readLine() ?: "Wipro Training"

    println("Enter Event Date:")
    val date = readLine() ?: "20-07-2024"

    println("Enter Event Name:")
    val attendeeCount = readLine()?.toIntOrNull() ?: 30
    
    val event = Event( name, date, attendeeCount )
    println("Event Created: $event")

    println("Categorize the event: (1) Workshop, (2) Conference, (3) Meetup")

    val category = readLine()?.toIntOrNull() ?: 2

    val eventType = when (category) {

    1-> "Workshop"

    2-> "Conference"

    3 -> "Meetup"

    else -> "Unknown"

    }

println("Event Type: $eventType")

}

