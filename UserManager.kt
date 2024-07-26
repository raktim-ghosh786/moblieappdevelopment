data class User(val id: Int, val name: String, val email: String)

class UserManager {
    
    private val users = mutableListOf<User>()
    
    fun addUser(user: User){
        users.add(user)
    }
    fun removeUser(user: User){
        users.remove(user)
    }
    fun getAllUsers(): List<User>{
        return users   
    }
    
}

fun main() {
    
    val userManager = UserManager()
    val user1 = User(1,"Raktim","rakghosh786@gamil.com")
    val user2 = User(2,"Aaryan","aaryan@gmail.com")
    
    userManager.addUser(user1)
	userManager.addUser(user2)
	println(userManager.getAllUsers())
    
    userManager.removeUser(user2)
	println(userManager.getAllUsers())
    
}