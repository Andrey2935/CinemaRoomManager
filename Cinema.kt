package cinema

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    val table: Array<Array<String>> = Array(rows) { Array(seats) { "S" } }
    var current = 0
    var purch = 0.0
    while (true) {
        var a = 1
        println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit")
        when (readln().toInt()) {
            1 -> {
                println("Cinema:")
                print(" ")
                for (i in 1..seats) {
                    print(" $i")
                }
                println()
                for (i in table) {
                    print(a)
                    a++
                    for (j in i) {
                        print(" $j")
                    }
                    println()
                }
            }
            2 -> {
                val total = rows * seats
                var xRow = 0
                var ySeats = 0
                while (true) {
                    println()
                    println("Enter a row number:")
                    xRow = readln().toInt()
                    println()
                    println("Enter a seat number in that row:")
                    ySeats = readln().toInt()
                    if (xRow !in 1..rows || ySeats !in 1..seats){
                        println("Wrong input!")
                    } else if (table[xRow - 1][ySeats - 1] == "B") {
                        println("That ticket has already been purchased!")
                    } else break
                }
                var cost = if (total > 60 && xRow > rows / 2) 8 else 10
                println()
                println("Ticket price: $$cost")
                current += cost
                purch++
                table[xRow - 1][ySeats - 1] = "B"
            }
            3 -> {
                println("Number of purchased tickets: ${purch.toInt()}")
                println("Percentage: ${"%.2f".format(purch / (rows * seats) * 100)}%")
                println("Current income: $$current")
                println("Total income: $${totalIncom(rows, seats)}")
            }
            0 -> break
        }
    }
}

fun totalIncom(rows: Int, seats: Int): Int {
    val total = rows * seats
    var cost = 0
    if (total <= 60) cost = total * 10
    else {
        if (rows % 2 == 0) cost = ((rows / 2 * seats * 10) + (rows / 2 * seats * 8))
        else cost = rows / 2 * seats * 10 + ((rows / 2) + 1) * seats * 8
    }
    return cost
}