data class Transaction(
    val amount: Double,
    val date: String,
    val category: String
)
fun categorizeTransaction(transaction: Transaction): String {
    return when (transaction.category) {
        "Food" -> "This is a food-related expense."
        "Utilities" -> "This is a utilities expense."
        "Entertainment" -> "This is an entertainment expense."
        else -> "Other expense category."
    }
}

fun main() {
    val transaction1 = Transaction(50.0, "18-07-2024", "Food")
    val transaction2 = Transaction(100.0, "19-07-2024", "Utilities")
    val transaction3 = Transaction(100.0, "20-07-2024", "Rent")

    println(categorizeTransaction(transaction1))
    println(categorizeTransaction(transaction2))
    println(categorizeTransaction(transaction3))
}