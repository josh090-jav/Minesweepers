package minesweeper

fun main() {
    val mine = Minefield
    val gen = MineGenerator()
    var count = 0
    println("How many mines do you want on the field?")
    readLine()?.let { gen.generate(it.toInt()) }
    mine.reload()
    while (true) {
        println("Set/unset mines marks or claim a cell as free:")
        val cods = readLine()!!
        gen.upAndCheck(cods, count)
        ++count
//        mine.reload()
    }
}
