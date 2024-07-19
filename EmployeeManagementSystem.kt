data class Employee(
    var id: Int,
    var name: String,
    var position: String,
    var salary: Double
)

class EmployeeManagementSystem {
    private val employees = mutableListOf<Employee>()

    fun addEmployee(employee: Employee) {
        employees.add(employee)
        println("Employee added: $employee")
    }

    fun displayAllEmployees() {
        if (employees.isEmpty()) {
            println("No employees to display.")
        } else {
            println("Employee List:")
            employees.forEach { println(it) }
        }
    }

    fun editEmployee(id: Int, newName: String, newPosition: String, newSalary: Double) {
        val employee = employees.find { it.id == id }
        if (employee != null) {
            employee.name = newName
            employee.position = newPosition
            employee.salary = newSalary
            println("Employee updated: $employee")
        } else {
            println("Employee with id $id not found.")
        }
    }

    fun deleteEmployee(id: Int) {
        val employee = employees.find { it.id == id }
        if (employee != null) {
            employees.remove(employee)
            println("Employee removed: $employee")
        } else {
            println("Employee with id $id not found.")
        }
    }
}
fun main() {
  
    val system = EmployeeManagementSystem()

    val emp1 = Employee(1, "Raktim", "Developer", 60000.0)
    val emp2 = Employee(2, "Aaryam", "Trainer", 80000.0)
    val emp3 = Employee(3, "Ayan", "Manager", 100000.0)
    system.addEmployee(emp1)
    system.addEmployee(emp2)
    system.addEmployee(emp3)

   	system.displayAllEmployees()

    system.editEmployee(2, "Aaryan", "Manager", 90000.0)
    system.displayAllEmployees()

    system.deleteEmployee(3)
    system.displayAllEmployees()
}
