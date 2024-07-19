open class Event(var id: Int,
                 var name: String,
                 var date: String,
                 var location: String)

class SpecialEvent(id: Int, name: String, date: String, location: String) : Event(id, name, date, location) {
    
    private val vipList = mutableListOf<String>()
    private val premiumServices = mutableListOf<String>()

    fun addVip(guest: String) {
        vipList.add(guest)
    }

    fun removeVip(guest: String): Boolean {
        return vipList.remove(guest)
    }

    fun addPremiumService(service: String) {
        premiumServices.add(service)
    }

    fun removePremiumService(service: String): Boolean {
        return premiumServices.remove(service)
    }

    fun showVipList() {
        println("VIP List: $vipList")
    }

    fun showPremiumServices() {
        println("Premium Services: $premiumServices")
    }
}

interface Display {
    fun showEventDetails(event: Event)
}

class EventManager : Display {
    private val events = mutableListOf<Event>()
    private var nextId = 1
	private val notificationHandlers = mutableListOf<(Event) -> Unit>()
    
    fun addEvent(name: String, date: String, location: String): Event {
       val event = Event(nextId++, name, date, location)
        events.add(event)
        notify(event)
        return event
    }

    fun removeEvent(id: Int): Boolean {
        val event = events.find { it.id == id } ?: return false
        events.remove(event)
        notify(event)
        return true
    }

    fun getAllEvents(): List<Event> = events
    
    override fun showEventDetails(event: Event) {
        println("Event Details - ID: ${event.id}, Name: ${event.name}, Date: ${event.date}, Location: ${event.location}")
    }
    fun registerNotificationHandler(handler: (Event) -> Unit) {
        notificationHandlers.add(handler)
    }

    private fun notify(event: Event) {
        notificationHandlers.forEach { it(event) }
    }
}
fun main() {
   val eventManager = EventManager()

    // Registering notification handler
    eventManager.registerNotificationHandler { event -> 
        println("Event updated: ${event.name} on ${event.date} at ${event.location}")
    }

    // Adding events
    val event1 = eventManager.addEvent("Sangeet", "18-07-2024", "Kolkata")
    val event2 = eventManager.addEvent("Wedding", "20-07-2024", "Delhi")

    // Showing event details
    eventManager.showEventDetails(event1)
    eventManager.showEventDetails(event2)

    // Removing an event
    eventManager.removeEvent(event1.id)

    // Special event
    val specialEvent = SpecialEvent(3, "Dinner", "2024-08-10", "Chandigarh")
    specialEvent.addVip("Virat Kohli")
    specialEvent.addPremiumService("Dancing")
    specialEvent.showVipList()
    specialEvent.showPremiumServices()
}