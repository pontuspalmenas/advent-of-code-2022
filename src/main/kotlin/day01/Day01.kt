package day01

import util.FileUtil

fun main(args: Array<String>) {
    val ll = FileUtil("input/day01.txt").intBlocks()
    println(solve1(ll))
    println(solve2(ll))
}

fun solve1(ll: List<List<Int>>): Int {
    return ll.map { it.sum() }.maxOf { it }
}

fun solve2(ll: List<List<Int>>): Int {
    return ll.map { it.sum() }.sortedDescending().take(3).sum()
}