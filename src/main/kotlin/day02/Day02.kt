package day02

import util.FileUtil
import java.lang.IllegalStateException

fun main(args: Array<String>) {
    val l = FileUtil("input/day02.txt").lines()
    println(solve1(l))
    //println(solve2(ll))
}

fun solve1(l: List<String>): Int {
    var x = 0

    l.forEach {
        val s = it.replace("X","A").replace("Y","B").replace("Z","C")
        x += score(s[0], s[2])
    }

    return x
}

fun score(a: Char, b: Char): Int {
    val loss = 0
    val draw = 3
    val win = 6
    val rock = 'A'
    val paper = 'B'
    val scissors = 'C'

    if (a == b) return draw + value(b)
    if (a == rock && b == paper) return win + value(b)
    if (a == rock && b == scissors) return loss + value(b)
    if (a == paper && b == scissors) return win + value(b)
    if (a == paper && b == rock) return loss + value(b)
    if (a == scissors && b == rock) return win + value(b)
    if (a == scissors && b == paper) return loss + value(b)

    throw IllegalStateException("uh oh")
}

fun solve2(ll: List<List<Int>>): Int {
    return ll.map { it.sum() }.sortedDescending().take(3).sum()
}

fun needed(a: Char, b: Char): Char {
    if (b == 'A') return needToLose(a)
    if (b == 'B') return needToDraw(a)
    if (b == 'C') return needToWin(a)
    throw IllegalStateException("uh oh")
}

fun needToWin(c: Char): Char {
    when (c) {
        'A' -> return 'B'
        'B' -> return 'C'
        'C' -> return 'A'
    }
    throw IllegalStateException("uh oh")
}

fun needToLose(c: Char): Char {
    throw IllegalStateException("uh oh")
}

fun needToDraw(c: Char): Char {
    throw IllegalStateException("uh oh")
}

fun value(c: Char): Int {
    when (c) {
        'A' -> return 1
        'B' -> return 2
        'C' -> return 3
    }
    throw IllegalStateException("no value")
}