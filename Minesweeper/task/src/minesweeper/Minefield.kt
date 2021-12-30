package minesweeper

object Minefield {
    val mineField = mutableListOf(
        mutableListOf(".", ".", ".", ".", ".", ".", ".", ".","."),
        mutableListOf(".", ".", ".", ".", ".", ".", ".", ".","."),
        mutableListOf(".", ".", ".", ".", ".", ".", ".", ".","."),
        mutableListOf(".", ".", ".", ".", ".", ".", ".", ".","."),
        mutableListOf(".", ".", ".", ".", ".", ".", ".", ".","."),
        mutableListOf(".", ".", ".", ".", ".", ".", ".", ".","."),
        mutableListOf(".", ".", ".", ".", ".", ".", ".", ".","."),
        mutableListOf(".", ".", ".", ".", ".", ".", ".", ".","."),
        mutableListOf(".", ".", ".", ".", ".", ".", ".", ".","."),
    )
    fun reload() {
        val top = " |123456789|"
        val bel = "-|---------|"
        println("$top")
        println("$bel")
        var lev = 0
        for (w in mineField) {
            print("${++lev}|")
            for (h in w) {
                print("$h")
            }
            print("|")
            println("")
        }
        println("$bel")
    }

}