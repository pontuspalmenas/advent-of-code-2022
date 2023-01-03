package day18

import util.FileUtil
import util.Point3
import util.ints

fun main(args: Array<String>) {
    val l = FileUtil("input/day18.txt").lines()
    println(solve1(l))
    println(solve2(l))
}

fun solve1(l: List<String>): Int {
    val cubes = parse(l)
    var sum = 0
    cubes.forEach { c ->
        c.nonDiagonalNeighs().forEach { n ->
            if (!cubes.contains(n)) sum++
        }
    }
    return sum
}

fun solve2(l: List<String>): Int {
    val cubes = parse(l)
    var sum = 0
    val min = cubes.minBy {it.x + it.y + it.z}.plus(Point3(-1,-1,-1))
    val max = cubes.maxBy {it.x + it.y + it.z}.plus(Point3(1,1,1))

    val water = floodFill(cubes, min, min, max)

    cubes.forEach { c ->
        c.nonDiagonalNeighs().forEach {
            if (!cubes.contains(it) && water.contains(it)) sum++
        }
    }

    return sum
}

fun floodFill(cubes: Set<Point3>, pos: Point3, min: Point3, max: Point3): Set<Point3> {
    val water = mutableSetOf<Point3>()

    val queue = ArrayDeque<Point3>()
    queue.add(pos)

    val outsideMin = min.plus(Point3(-1,-1,-1))
    val outsideMax = min.plus(Point3(1,1,1))

    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()

        if (water.contains(curr)) continue
        water.add(curr)

        curr.nonDiagonalNeighs().forEach {
            if (!cubes.contains(it) && !water.contains(it) && isInside(it, outsideMin, outsideMax)) {
                queue.addLast(it)
            }
        }
    }

    return water
}

fun isInside(pos: Point3, min: Point3, max: Point3): Boolean {
    return pos.x >= min.x && pos.x < max.x &&
            pos.y >= min.y && pos.y < max.y &&
            pos.z >= min.z && pos.z < max.z
}

fun parse(l: List<String>): Set<Point3> {
    val set = mutableSetOf<Point3>()
    l.forEach {
        val (x,y,z) = ints(it)
        set.add(Point3(x,y,z))
    }
    return set
}