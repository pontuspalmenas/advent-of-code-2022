package day22

import util.FileUtil

fun main(args: Array<String>) {
    val l = FileUtil("input/day21.txt").lines()
    val d = Day22(l)
    println(d.solve1())
}

class Day22(input: List<String>) {
    fun solve1(): Int {
        return -1
    }
}