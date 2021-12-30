package minesweeper

import kotlin.math.abs
import kotlin.random.Random
import kotlin.system.exitProcess

//import kotlin.random.Random.Default.nextBoolean

class MineGenerator {
    private val mine = Minefield
//    var dy = 0
//    var dx = 0
    private var count = 0
    private var counter = 1
    private val rand = Random.Default
    private val xCords = mutableListOf<String>()
    private val playedCords = mutableListOf<String>()
    private val numCords = mutableMapOf<String, String>()
    private val empCords = mutableListOf<String>()
    fun generate(n: Int) {
        while (count < n) {
            val dy = rand.nextInt(0, 9)
            val dx = rand.nextInt(0, 9)
            if (mine.mineField[dy][dx] != "X") {
                mine.mineField[dy][dx] = "X"
                xCords.add("$dy $dx")
                ++count
            }
        }
        countMines()
        for (w in 0..8) {
            for(x in 0..8) {
                if(mine.mineField[w][x] == "X") {
                    mine.mineField[w][x] = "."
//                    println("b/4 cc: $w $x")
                }
            }
        }
    }
    private fun countMines() {
        for (w in 0..8) {
            for (z in 0..8) {
                if (mine.mineField[w][z] == ".") {
                    if (z == 0 && w == 0) {
                        var n = 0
                        for (hh in 0..1) {
                                if (mine.mineField[w][z + hh] == "X") ++n
                                if (mine.mineField[w + 1][z + hh] == "X") ++n
                            }
                        if (n > 0) {
                            numCords["$w $z"] = "$n"
//                            println("numCord dy: $w dx: $z & num: $n")
//                            mine.mineField[w][z] = n.toString()
                        }
                    }
                    if (z in 1..7 && w == 0) {
                        var n = 0
                        if (mine.mineField[w][z - 1] == "X") ++n
                        if (mine.mineField[w][z + 1] == "X") ++n
                        if (mine.mineField[w + 1][z + 1] == "X") ++n
                        if (mine.mineField[w + 1][z - 1] == "X") ++n
                        if (mine.mineField[w + 1][z] == "X") ++n
                        if (n > 0) {
//                            mine.mineField[w][z] = n.toString()
                            numCords.put("$w $z", "$n")
//                            println("numCord dy: $w dx: $z & num: $n")
                        }
                    }
                    if (z == 8 && w == 0) {
                        var n = 0
                        if (mine.mineField[w][z - 1] == "X") ++n
                        if (mine.mineField[w + 1][z - 1] == "X") ++n
                        if (mine.mineField[w + 1][z] == "X") ++n
                        if (n > 0) {
//                            mine.mineField[w][z] = n.toString()
                            numCords.put("$w $z", "$n")
//                            println("numCord dy: $w dx: $z & num: $n")
                        }
                    }
                    if (w in 1..7) {
                        if (z == 0) {
                            var n = 0
                            if (mine.mineField[w - 1][z] == "X") ++n
                            if (mine.mineField[w - 1][z + 1] == "X") ++n
                            if (mine.mineField[w][z + 1] == "X") ++n
                            if (mine.mineField[w + 1][z] == "X") ++n
                            if (mine.mineField[w + 1][z + 1] == "X") ++n
                            if (n > 0) {
//                            mine.mineField[w][z] = n.toString()
                                numCords.put("$w $z", "$n")
//                                println("numCord dy: $w dx: $z & num: $n")
                            }
                        }
                        if (z in 1..7) {
                            var n = 0
                            if (mine.mineField[w - 1][z] == "X") ++n
                            if (mine.mineField[w - 1][z - 1] == "X") ++n
                            if (mine.mineField[w - 1][z + 1] == "X") ++n
                            if (mine.mineField[w][z + 1] == "X") ++n
                            if (mine.mineField[w][z - 1] == "X") ++n
                            if (mine.mineField[w + 1][z] == "X") ++n
                            if (mine.mineField[w + 1][z + 1] == "X") ++n
                            if (mine.mineField[w + 1][z - 1] == "X") ++n
                            if (n > 0) {
//                            mine.mineField[w][z] = n.toString()
                                numCords.put("$w $z", "$n")
//                                println("numCord dy: $w dx: $z & num: $n")
                            }
                        }
                        if (z == 8) {
                            var n = 0
                            if (mine.mineField[w - 1][z] == "X") ++n
                            if (mine.mineField[w - 1][z - 1] == "X") ++n
                            if (mine.mineField[w][z - 1] == "X") ++n
                            if (mine.mineField[w + 1][z] == "X") ++n
                            if (mine.mineField[w + 1][z - 1] == "X") ++n
                            if (n > 0) {
//                            mine.mineField[w][z] = n.toString()
                                numCords.put("$w $z", "$n")
//                                println("numCord dy: $w dx: $z & num: $n")
                            }
                        }
                    }
                    if (w == 8) {
                        if (z == 0) {
                            var n = 0
                            if (mine.mineField[w - 1][z] == "X") ++n
                            if (mine.mineField[w - 1][z + 1] == "X") ++n
                            if (mine.mineField[w][z + 1] == "X") ++n
//                            if (mine.mineField[w + 1][z] == "X") ++n
//                            if (mine.mineField[w + 1][z + 1] == "X") ++n
                            if (n > 0) {
//                            mine.mineField[w][z] = n.toString()
                                numCords.put("$w $z", "$n")
//                                println("numCord dy: $w dx: $z & num: $n")
                            }
                        }
                        if (z in 1..7) {
                            var n = 0
                            if (mine.mineField[w - 1][z] == "X") ++n
                            if (mine.mineField[w - 1][z - 1] == "X") ++n
                            if (mine.mineField[w - 1][z + 1] == "X") ++n
                            if (mine.mineField[w][z + 1] == "X") ++n
                            if (mine.mineField[w][z - 1] == "X") ++n
//                            if (mine.mineField[w + 1][z] == "X") ++n
//                            if (mine.mineField[w + 1][z + 1] == "X") ++n
//                            if (mine.mineField[w + 1][z - 1] == "X") ++n
                            if (n > 0) {
//                            mine.mineField[w][z] = n.toString()
                                numCords.put("$w $z", "$n")
//                                println("numCord dy: $w dx: $z & num: $n")
                            }
                        }
                        if (z == 8) {
                            var n = 0
                            if (mine.mineField[w - 1][z] == "X") ++n
                            if (mine.mineField[w - 1][z - 1] == "X") ++n
                            if (mine.mineField[w][z - 1] == "X") ++n
//                            if (mine.mineField[w + 1][z] == "X") ++n
//                            if (mine.mineField[w + 1][z - 1] == "X") ++n
                            if (n > 0) {
//                            mine.mineField[w][z] = n.toString()
                                numCords.put("$w $z", "$n")
//                                println("numCord dy: $w dx: $z & num: $n")
                            }
                        }
                    }
                }
            }
        }
    }
    fun upAndCheck(vale: String, count: Int) {
        val div = vale.split(" ")
        val dx = div[0].toInt()
        val dy = div[1].toInt()
        val play = div[2]
        if (count <= 0) {
            if (mine.mineField[dy - 1][dx - 1] == "X") {
                xCords.remove("${dy - 1} ${dx - 1}")
                mine.mineField[dy - 1][dx - 1] = "."
                for (y in 0..8) {
                    for (b in 0..8) {
                        if (mine.mineField[y][b] != "X") {
                            xCords.add("$b $y")
                            mine.mineField[y][b] = "."
                            break
                        }
                    }
                }
                countMines()
            }
        }
        if (mine.mineField[dy - 1][dx - 1] == "*" && play == "mine") {
            mine.mineField[dy - 1][dx - 1] = "."
//            playedCords.remove("$dy$dx")
            playedCords.remove("${dy - 1}${dx - 1}")
            mine.reload()
        } else if (mine.mineField[dy - 1][dx - 1] != "*" && play == "mine") {
            mine.mineField[dy - 1][dx - 1] = "*"
            playedCords.add("${dy - 1}${dx - 1}")
            mine.reload()
        }
        if (play == "free") {
            xPlore("$dy $dx $play")
//            checkPos("$dy $dx $play")
            mine.reload()
        }
        emptyCells()
        empCords.sort()
        playedCords.sort()
        xCords.sort()
//        println("Played $playedCords && Coords $xCords")
        if (xCords == playedCords || xCords == empCords) {
            println("Congratulations! You found all the mines!")
            exitProcess(0)
        }
    }


    private fun xPlore(cord: String) {
        val cc = cord.split(" ")
        val dy = cc[0].toInt() - 1
        val dx = cc[1].toInt() - 1
        val cords = cc[2]
        xCords.sort()
        println(xCords)
        if(gameOver(dy, dx, cords)) exitProcess(0)
        checkPos(dy, dx)
    }

    private fun markedCell(dy: Int, dx: Int): Boolean {
        for (w in xCords) {
//            println("mark cords: $w")
            if (w.matches(Regex("$dy $dx"))) {
//                println("Xcord: $w and ${dy - 1} ${dx - 1}")
                return true
            }
        }
        return false
    }


    private fun emptyCells() {
        for (a in 0..8) {
            for (b in 0..8) {
                if (mine.mineField[a][b] != "/") empCords.add("$a $b")
            }
        }
    }

    private fun checkPos(dy: Int, dx: Int) {
//        val co = cord.split(" ")
//        var dy = co[0].toInt()
//        var dx = co[1].toInt()
        when {
            dy in 1..7 && dx in 1..7 -> center(dy, dx)
            dy == 0 && dx == 0 -> topLeft(dy, dx)
            dy == 0 && dx == 8 -> topRight(dy, dx)
            dy in 1..7 && dx == 0 -> leftCenter(dy, dx)
            dy in 1..7 && dx == 8 -> rightCenter(dy, dx)
            dy == 8 && dx in 1..7 -> bottomCenter(dy, dx)
            dy == 0 && dx in 1..7 -> topCenter(dy, dx)
            dy == 8 && dx == 0 -> bottomLeft(dy, dx)
            dy == 8 && dx == 8 -> bottomRight(dy, dx)
//            else -> exitProcess(0)
        }
    }

    private fun center(dy: Int, dx: Int) {

        self(dy, dx)

        selfFront(dy, dx)

        selfBack(dy, dx)

        selfUp(dy, dx)

        selfDown(dy, dx)

        upLeft(dy, dx)

        upRight(dy, dx)

        downLeft(dy, dx)

        downRight(dy, dx)
    }

    private fun bottomRight(dy: Int, dx: Int) {
        self(dy, dx)

        selfUp(dy, dx)

        upLeft(dy, dx)

        selfBack(dy, dx)
    }
//
    private fun bottomLeft(dy: Int, dx: Int) {
        self(dy, dx)
        selfFront(dy, dx)
        selfUp(dy, dx)
        upRight(dy, dx)
    }
//
    private fun topCenter(dy: Int, dx: Int) {
    self(dy, dx)

    selfFront(dy, dx)

    selfBack(dy, dx)

//    selfUp(dy, dx)

    selfDown(dy, dx)

//    upLeft(dy, dx)

//    upRight(dy, dx)

    downLeft(dy, dx)

    downRight(dy, dx)

    }
//
    private fun bottomCenter(dy: Int, dx: Int) {
    self(dy, dx)

    selfFront(dy, dx)

    selfBack(dy, dx)

    selfUp(dy, dx)

//    selfDown(dy, dx)

    upLeft(dy, dx)

    upRight(dy, dx)

//    downLeft(dy, dx)

//    downRight(dy, dx)
    }
//
    private fun leftCenter(dy: Int, dx: Int) {
        self(dy, dx)

        selfFront(dy, dx)

//    selfBack(dy, dx)

        selfUp(dy, dx)

        selfDown(dy, dx)

//    upLeft(dy, dx)

        upRight(dy, dx)

//    downLeft(dy, dx)

        downRight(dy, dx)
    }
//
    private fun rightCenter(dy: Int, dx: Int) {
    self(dy, dx)

//    selfFront(dy, dx)

    selfBack(dy, dx)

    selfUp(dy, dx)

    selfDown(dy, dx)

    upLeft(dy, dx)

//    upRight(dy, dx)

    downLeft(dy, dx)

//    downRight(dy, dx)
    }
//
    private fun topRight(dy: Int, dx: Int) {
    self(dy, dx)

//    selfFront(dy, dx)

    selfBack(dy, dx)

//    selfUp(dy, dx)

    selfDown(dy, dx)

//    upLeft(dy, dx)

//    upRight(dy, dx)

    downLeft(dy, dx)

//    downRight(dy, dx)
    }
//
    private fun topLeft(dy: Int, dx: Int) {

    self(dy, dx)

    selfFront(dy, dx)

//    selfBack(dy, dx)

//    selfUp(dy, dx)

    selfDown(dy, dx)

//    upLeft(dy, dx)

//    upRight(dy, dx)

//    downLeft(dy, dx)

    downRight(dy, dx)
    }

    private fun gameOver(dy: Int, dx: Int, p: String): Boolean {
        var str = false
        if(markedCell(dy, dx) && p == "free") {
            for (w in 0..8) {
                for (y in 0..8) {
                    for(ww in xCords) {
                        if(ww == "$w $y") {
                            mine.mineField[w][y] = "X"
                        }
                    }
                }
            }
            mine.reload()
           println("You stepped on a mine and failed!")
            str = true
        }
        return str
    }

    private fun markRight(dy: Int, dx: Int): Boolean {
        var res = false
        if(mine.mineField[dy][dx] == "*" && !(markedCell(dy, dx))){
            res = true
        }
        return res
    }

    private fun self(dy: Int, dx: Int) {
        if(mine.mineField[dy][dx] == "." && numCords["$dy $dx"] == null && !(markedCell(dy, dx))) {
            mine.mineField[dy][dx] = "/"
            if(markedCell(dy, dx)) ++counter
        } else if (numCords["$dy $dx"] != null && !(markedCell(dy, dx))) {
            mine.mineField[dy][dx] = numCords["$dy $dx"].toString()
        } else if (markRight(dy, dx)) mine.mineField[dy][dx] = "/"
    }

    private fun selfFront(dy: Int, dx: Int) {
        if(mine.mineField[dy][dx + 1] == "." && numCords["$dy ${dx + 1}"] == null && !(markedCell(dy, dx + 1))) {
            mine.mineField[dy][dx + 1] = "/"
            if(markedCell(dy, dx + 1)) ++counter
            checkPos(dy, dx + 1)
        } else if (numCords["$dy ${dx + 1}"] != null && !(markedCell(dy, dx + 1))) {
            mine.mineField[dy][dx + 1] = numCords["$dy ${dx + 1}"].toString()
        }else if (markRight(dy, dx + 1)) mine.mineField[dy][dx + 1] = "/"
    }

    private fun selfBack(dy: Int, dx: Int) {
        if(mine.mineField[dy][dx - 1] == "." && numCords["$dy ${dx - 1}"] == null && !(markedCell(dy, dx - 1))) {
            mine.mineField[dy][dx - 1] = "/"
            if(markedCell(dy, dx - 1)) ++counter
            checkPos(dy, dx - 1)
        } else if (numCords["$dy ${dx - 1}"] != null && !(markedCell(dy, dx - 1))) {
            mine.mineField[dy][dx - 1] = numCords["$dy ${dx - 1}"].toString()
        } else if (markRight(dy, dx - 1)) mine.mineField[dy][dx - 1] = "/"
    }

    private fun selfUp(dy: Int, dx: Int) {
        if(mine.mineField[dy - 1][dx] == "." && numCords["${dy - 1} $dx"] == null && !(markedCell(dy - 1, dx))) {
            mine.mineField[dy - 1][dx] = "/"
            if(markedCell(dy - 1, dx)) ++counter
            checkPos(dy - 1, dx)
        } else if (numCords["${dy - 1} $dx"] != null && !(markedCell(dy - 1, dx))) {
            mine.mineField[dy - 1][dx] = numCords["${dy - 1} $dx"].toString()
        } else if (markRight(dy - 1, dx)) mine.mineField[dy - 1][dx] = "/"
    }

    private fun selfDown(dy: Int, dx: Int) {
        if(mine.mineField[dy + 1][dx] == "." && numCords["${dy + 1} $dx"] == null && !(markedCell(dy + 1, dx))) {
            mine.mineField[dy + 1][dx] = "/"
            if(markedCell(dy + 1, dx)) ++counter
            checkPos(dy + 1, dx)
        } else if (numCords["${dy + 1} $dx"] != null && !(markedCell(dy + 1, dx))) {
            mine.mineField[dy + 1][dx] = numCords["${dy + 1} $dx"].toString()
        } else if (markRight(dy + 1, dx)) mine.mineField[dy + 1][dx] = "/"
    }

    private fun upRight(dy: Int, dx: Int) {
        if(mine.mineField[dy - 1][dx + 1] == "." && numCords["${dy - 1} ${dx + 1}"] == null && !(markedCell(dy - 1, dx + 1))) {
            mine.mineField[dy - 1][dx + 1] = "/"
            if(markedCell(dy - 1, dx + 1)) ++counter
            checkPos(dy - 1, dx + 1)
        } else if (numCords["${dy - 1} ${dx + 1}"] != null && !(markedCell(dy - 1, dx + 1))) {
            mine.mineField[dy - 1][dx + 1] = numCords["${dy - 1} ${dx + 1}"].toString()
        } else if (markRight(dy - 1, dx + 1)) mine.mineField[dy - 1][dx + 1] = "/"
    }

    private fun upLeft(dy: Int, dx: Int) {
        if(mine.mineField[dy - 1][dx - 1] == "." && numCords["${dy - 1} ${dx - 1}"] == null && !(markedCell(dy - 1, dx - 1))) {
            mine.mineField[dy - 1][dx - 1] = "/"
            if(markedCell(dy - 1, dx - 1)) ++counter
            checkPos(dy - 1, dx - 1)
        } else if (numCords["${dy - 1} ${dx - 1}"] != null && !(markedCell(dy - 1, dx - 1))) {
            mine.mineField[dy - 1][dx - 1] = numCords["${dy - 1} ${dx - 1}"].toString()
        } else if (markRight(dy - 1, dx - 1)) mine.mineField[dy - 1][dx - 1] = "/"
    }

    private fun downRight(dy: Int, dx: Int) {
        if(mine.mineField[dy + 1][dx + 1] == "." && numCords["${dy + 1} ${dx + 1}"] == null && !(markedCell(dy + 1, dx + 1))) {
            mine.mineField[dy + 1][dx + 1] = "/"
            if(markedCell(dy + 1, dx + 1)) ++counter
            checkPos(dy + 1, dx + 1)
        } else if (numCords["${dy + 1} ${dx + 1}"] != null && !(markedCell(dy + 1, dx + 1))) {
            mine.mineField[dy + 1][dx + 1] = numCords["${dy + 1} ${dx + 1}"].toString()
        } else if (markRight(dy + 1, dx + 1)) mine.mineField[dy + 1][dx + 1] = "/"
    }

    private fun downLeft(dy: Int, dx: Int) {
        if(mine.mineField[dy + 1][dx - 1] == "." && numCords["${dy + 1} ${dx - 1}"] == null && !(markedCell(dy + 1, dx - 1))) {
            mine.mineField[dy + 1][dx - 1] = "/"
            if(markedCell(dy + 1, dx - 1)) ++counter
            checkPos(dy + 1, dx - 1)
        } else if (numCords["${dy + 1} ${dx - 1}"] != null && !(markedCell(dy + 1, dx - 1))) {
            mine.mineField[dy + 1][dx - 1] = numCords["${dy + 1} ${dx - 1}"].toString()
        } else if (markRight(dy + 1, dx - 1)) mine.mineField[dy + 1][dx - 1] = "/"
    }

}