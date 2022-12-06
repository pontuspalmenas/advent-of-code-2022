package day04

import util.FileUtil

fun main(args: Array<String>) {
    val l = FileUtil("input/day04.txt").lines()
    println(solve1(l))
    println(solve2(l))
}

fun solve1(l: List<String>): Int {
    var sum = 0
    l.forEach {
        val s = it.split(",")
        // todo, regex get all positive integers
        val p1 = s[0].split("-").map { i -> Integer.parseInt(i) }
        val p2 = s[1].split("-").map { i -> Integer.parseInt(i) }

        if (overlaps(p1, p2)) {
            sum++
        }
    }

    return sum
}

fun overlaps(p1: List<Int>, p2: List<Int>): Boolean {
    return (p1[0] <= p2[0] && p1[1] >= p2[1]) || (p2[0] <= p1[0] && p2[1] >= p1[1])
}

fun solve2(l: List<String>): Int {
    var sum = 0
    l.forEach {
        val s = it.split(",")
        val p1 = s[0].split("-").map { i -> Integer.parseInt(i) }
        val p2 = s[1].split("-").map { i -> Integer.parseInt(i) }
        val s1 = toSet(p1[0],p1[1])
        val s2 = toSet(p2[0],p2[1])
        if (s1.intersect(s2).isNotEmpty()) sum++
    }

    return sum
}

fun toSet(a: Int, b: Int): Set<Int> {
    val s = mutableSetOf<Int>()
    var i = a
    while (i <= b) {
        s.add(i)
        i++
    }
    return s
}
