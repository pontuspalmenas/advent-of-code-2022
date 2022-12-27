package day05

import util.FileUtil
import util.ints

fun main(args: Array<String>) {
    val l = FileUtil("input/day05.txt").lines()
    val d = Day05(l)
    println(d.solve1())
    println(d.solve2())
}

class Day05(private val input: List<String>) {
    fun solve1(): String {
        val stacks = parseStacks(input)

        input.forEach {
            if (it.startsWith("move")) {
                val (n, from, to) = ints(it)
                repeat(n) {
                    val c = stacks[from]!!.removeFirst()
                    stacks[to]!!.addFirst(c)
                }
            }
        }

        return stacks.values.map { it.first() }.joinToString("")
    }

    fun solve2(): String {
        val stacks = parseStacks(input)

        input.forEach {
            if (it.startsWith("move")) {
                val (n, from, to) = ints(it)
                stacks[from]!!.take(n).reversed().forEach { c -> stacks[to]!!.addFirst(c) }
                repeat(n) {stacks[from]!!.removeFirst()}
            }
        }

        return stacks.values.map { it.first() }.joinToString("")
    }

    private fun parseStacks(input: List<String>): MutableMap<Int, ArrayDeque<Char>> {
        val stacks = mutableMapOf<Int, ArrayDeque<Char>>().withDefault { ArrayDeque() }
        for (i in 1..9) {
            stacks[i] = ArrayDeque()
        }

        input.forEach {
            if (it.contains("[")) {
                var ix = 0
                while (ix < 9) {
                    val c = it[ix * 4 + 1]
                    if (c.isUpperCase()) stacks[ix+1]!!.addLast(c)
                    ix++
                }
            }
        }

        return stacks
    }
}

