interface Exportable {
    fun exportToCsv() : String
}
class Transaction(private var _id: Int, private var _amount: Double, private var _date: String) : Exportable {
    var id: Int
        get() = _id
        private set(value) { _id = value }

    var amount: Double
        get() = _amount
        set(value) { _amount = value }

    var date: String
        get() = _date
        set(value) { _date = value }

    override fun exportToCsv(): String {
        return "$_id,$_amount,$_date"
    }
}

fun <T : Collection<Transaction>> exportAllToCSV(transactions: T): String {
    return transactions.joinToString(separator = "\n") { it.exportToCsv() }
}

fun <K, V : Transaction> exportMapToCSV(transactionMap: Map<K, V>): String {
    return transactionMap.values.joinToString(separator = "\n") { it.exportToCsv() }
}

fun main() {
val transactions = listOf(
    Transaction(1, 100.0, "2024-07-26"),
    Transaction(2, 150.0, "2024-07-27")
)
println(exportAllToCSV(transactions))

val transactionMap = mapOf(
    1 to Transaction(3, 200.0, "2024-07-28"),
    2 to Transaction(4, 250.0, "2024-07-29")
)
println(exportMapToCSV(transactionMap))
}