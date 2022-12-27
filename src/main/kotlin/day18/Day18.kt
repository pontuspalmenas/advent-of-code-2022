package day18

import util.FileUtil
import util.Point3
import util.ints

fun main(args: Array<String>) {
    val l = FileUtil("input/day18.txt").lines()
    println(solve1(l))
}

fun solve1(l: List<String>): Int {

    return -1
}

fun parse(l: List<String>): Set<Point3> {
    val set = mutableSetOf<Point3>()
    l.forEach {
        val (x,y,z) = ints(it)
        set.add(Point3(x,y,z))
    }
    return set
}