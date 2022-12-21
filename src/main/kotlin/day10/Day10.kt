package day10

import util.FileUtil

fun main(args: Array<String>) {
    val l = FileUtil("input/day10.txt").lines()
    println(solve1(l))
    solve2(l)
}

fun solve1(l: List<String>): Int {
    var x = 1
    var cycle = 1
    var signalSums = 0

    l.forEach {
        cycle++
        if ((cycle - 20) % 40 == 0) signalSums += cycle * x

        if (!it.startsWith("noop")) {
            cycle++
            x += it.split(" ")[1].toInt()
            if ((cycle - 20) % 40 == 0) signalSums += cycle * x
        }
    }

    return signalSums
}

fun solve2(l: List<String>) {
    var x = 1
    var cycle = 0

    l.forEach {
        putPixel(x, cycle)
        cycle++
        if (cycle % 40 == 0) println("")
        if (!it.startsWith("noop")) {
            putPixel(x, cycle)
            x += it.split(" ")[1].toInt()
            cycle++
            if (cycle % 40 == 0) println("")
        }
    }
}

fun putPixel(x: Int, cycle: Int) {
    if (cycle % 40 == x - 1 || cycle % 40 == x || cycle % 40 == x + 1) print("#")
    else print(".")
}
