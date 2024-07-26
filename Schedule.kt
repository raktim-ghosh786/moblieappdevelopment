interface Schedulable{
    
    fun schedule(time: String)
    fun reschedule(newTime: String)
    
}
abstract class Event(private var _time: String) : Schedulable {
    var time: String
        get() = _time
        protected set(value) {
            _time = value
        }
}
class Meeting(time: String) : Event(time) {
   

    override fun schedule(time: String) {
        this.time = time
        println("Meeting scheduled at $time")
    }

    override fun reschedule(newTime: String) {
        this.time = newTime
        println("Meeting rescheduled to $newTime")
    }
    
    override fun toString(): String {
        return "Meeting(time='$time')"
    }
}

class Appointment(time: String) : Event(time) {
    
    override fun schedule(time: String) {
        this.time = time
        println("Appointment scheduled at $time")
    }

    override fun reschedule(newTime: String) {
        this.time = newTime
        println("Appointment rescheduled to $newTime")
    }
    override fun toString(): String {
        return "Appointment(time='$time')"
    }
}

class Schedule {
    private val events = mutableListOf<Event>()

    fun addEvent(event: Event) {
        events.add(event)
    }
      fun scheduleAll() {
        for (event in events) {
            // Assume scheduling at a default time for demonstration
            event.schedule("10:00 AM")
        }
    }

    fun rescheduleAll(newTime: String) {
        for (event in events) {
            event.reschedule(newTime)
        }
    } 
    fun filterEventsByTime(time: String): List<Event> {
        return events.filter { it.time == time }
    }

    fun filterEventsByType(eventType: Class<out Event>): List<Event> {
        return events.filter { it::class.java == eventType }
    }
}

class DataManager<T> {
    private val items = mutableListOf<T>()

    fun addItem(item: T) {
        items.add(item)
    }

    fun removeItem(item: T) {
        items.remove(item)
    }

    fun getAllItems(): List<T> {
        return items
    }
}


fun main() {
    
    val schedule = Schedule()
    val meeting = Meeting("10:00 AM")
    val appointment = Appointment("11:00 AM")
    
    schedule.addEvent(meeting)
    schedule.addEvent(appointment)
    
    // Schedule all events
    //schedule.scheduleAll()
    
   //Reschedule all events
    //schedule.rescheduleAll("2:00 PM")
    
	/*val eventsAt10AM = schedule.filterEventsByTime("10:00 AM")
    println("Events at 10:00 AM: $eventsAt10AM")

    val meetings = schedule.filterEventsByType(Meeting::class.java)
    println("Meetings: $meetings")
    
    val appointments = schedule.filterEventsByType(Appointment::class.java)
    println("Appointmentss: $appointments")*/
    
     val eventManager = DataManager<Event>()
    eventManager.addItem(meeting)
    eventManager.addItem(appointment)
    println("All events: ${eventManager.getAllItems()}")

    val attendeeManager = DataManager<String>()
    attendeeManager.addItem("Raktim")
    attendeeManager.addItem("Rohit")
    println("All attendees: ${attendeeManager.getAllItems()}")
}