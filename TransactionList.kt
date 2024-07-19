data class Transaction(
    var id: Int,
    var amount: Double,
    var date: String,
    var category: String
)

class TransactionList {
    private val transactions = mutableListOf<Transaction>()
    private var nextId = 1

    fun addTransaction(amount: Double, date: String, category: String) {
        val transaction = Transaction(nextId++, amount, date, category)
        transactions.add(transaction)
    }

    fun deleteTransaction(id: Int): Boolean {
        val transaction = transactions.find { it.id == id }
        return if (transaction != null) {
            transactions.remove(transaction)
            true
        } else {
            false
        }
    }

    fun editTransaction(id: Int, amount: Double, date: String, category: String): Boolean {
        val transaction = transactions.find { it.id == id }
        return if (transaction != null) {
            transaction.amount = amount
            transaction.date = date
            transaction.category = category
            true
        } else {
            false
        }
    }

    fun getAllTransactions(): List<Transaction> = transactions
    
    fun filterTransactions(predicate: (Transaction) -> Boolean): List<Transaction> {
        return transactions.filter(predicate)
    }

    fun sortTransactionsByAmount(): List<Transaction> {
        return transactions.sortedBy { it.amount }
    }

    fun sortTransactionsByDate(): List<Transaction> {
        return transactions.sortedBy { it.date }
    }
}
class User(private val username: String, private val password: String) {
    private var loggedIn = false
    private val transactionList = TransactionList()

    fun login(inputUsername: String, inputPassword: String): Boolean {
        loggedIn = (inputUsername == username && inputPassword == password)
        return loggedIn
    }

    fun addTransaction(amount: Double, date: String, category: String) {
        if (loggedIn) {
            transactionList.addTransaction(amount, date, category)
        } else {
            println("Please log in first.")
        }
    }

    fun displaySummary() {
        if (loggedIn) {
            val transactions = transactionList.getAllTransactions()
            val totalExpense = transactions.sumByDouble { it.amount }
            println("Total Expense: $$totalExpense")
            transactions.forEach { println(it) }
        } else {
            println("Please log in first.")
        }
    }
}
fun main() {
      val transactionList = TransactionList()

    // Attempt to add transaction without logging in
    transactionList.addTransaction(100.0, "2024-07-18", "Food")

    transactionList.addTransaction(1001.0, "2024-07-18", "Food")
    transactionList.addTransaction(50.0, "2024-07-19", "Entertainment")
	 val foodTransactions = transactionList.filterTransactions { it.category == "Food" }
    println("Food Transactions: $foodTransactions")

    // Sort transactions
    val sortedByAmount = transactionList.sortTransactionsByAmount()
    println("Transactions sorted by amount: $sortedByAmount")

    val sortedByDate = transactionList.sortTransactionsByDate()
    println("Transactions sorted by date: $sortedByDate")
 
}
