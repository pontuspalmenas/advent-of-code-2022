package day06

import util.FileUtil

fun main(args: Array<String>) {
    val s = FileUtil("input/day06.txt").text()
    println(solve(s, 4))
    println(solve(s, 14))
}

fun solve(s: String, size: Int): Int {
    for (i in 0..s.length-size) {
        if (s.substring(i,i+size).allUnique()) return i+size
    }

    return -1
}

fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)