package day21

import util.FileUtil
import java.lang.IllegalStateException

fun main(args: Array<String>) {
    val l = FileUtil("input/day21.txt").lines()
    println(solve1(l))
}

val solved = mutableMapOf<String, Long>()
val unsolved = mutableMapOf<String, String>()

fun solve1(l: List<String>): Long {
    l.forEach {
        val ops = it.replace(" ","").split(":")
        if (ops[1].toIntOrNull() != null) {
            solved[ops[0]] = ops[1].toLong()
        } else {
            unsolved[ops[0]] = ops[1]
        }
    }

    return solve("root")
}

fun solve(s: String): Long {
    if (solved.containsKey(s)) return solved[s]!!

    val a =  solve(unsolved[s]!!.substring(0,4))
    val b =  solve(unsolved[s]!!.substring(5))

    when (unsolved[s]!!.substring(4,5)) {
        "+" -> return a+b
        "-" -> return a-b
        "*" -> return a*b
        "/" -> return a/b
    }

    throw IllegalStateException("Couldn't solve for $s")
}
