package day03

import util.FileUtil

fun main(args: Array<String>) {
    val l = FileUtil("input/day03.txt").lines()
    println(solve1(l))
    println(solve2(l))
}

fun solve1(l: List<String>): Int {
    var score = 0
    l.forEach {
        val a = it.substring(0, it.length / 2).toSet()
        val b = it.substring(it.length / 2).toSet()

        val c = a.intersect(b).first()
        score += prio(c)
    }

    return score
}

fun solve2(l: List<String>): Int {
    var score = 0

    var i = 0
    while (i < l.size) {
        val c = l[i].toSet().intersect(l[i+1].toSet()).intersect(l[i+2].toSet()).first()
        score += prio(c)
        i += 3
    }

    return score
}

fun prio(c: Char): Int {
    return if (c.isUpperCase()) c.code - 64 + 26
    else c.code - 96
}

