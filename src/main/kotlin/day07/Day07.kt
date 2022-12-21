package day07

import day04.toSet
import util.FileUtil

fun main(args: Array<String>) {
    val l = FileUtil("input/day07.txt").lines()
    println(solve1(l))
    println(solve2(l))
}

// todo: lol, broke it while rewrite

var sumOfDirsUnder100k = 0
var smallestYet = Int.MAX_VALUE
var needToDeleteAtLeast = 0

val sizes = mutableMapOf<String, Int>()

fun solve1(l: List<String>): Int {
    val fs = initFS(l)
    sumForPart1(fs.root)
    return sumOfDirsUnder100k
}

fun solve2(l: List<String>): Int {
    val fs = initFS(l)
    val free = 70000000 - fs.used()
    val delete = 30000000 - free

    mapItOut(fs.root, "/")
    //sizes.keys.forEach { println("$it (${sizes[it]})") }

    return sizes.entries.sortedBy { it.value }.first { it.value > delete }.value
}

fun initFS(l: List<String>): VFS {
    val fs = VFS()

    l.forEach {
        val vs = it.split(" ")
        if (vs[0] == "$") {
            when (vs[1]) {
                "cd" -> fs.cd(vs[2])
            }
        } else {
            when (vs[0]) {
                "dir" -> fs.mkdir(vs[1])
                else -> fs.mkfile(vs[1], vs[0].toInt())
            }
        }
    }
    return fs
}

fun mapItOut(dir: Dir, path: String): Int {
    var sum = 0

    sum += dir.files.sumOf { it.size }
    sum += dir.dirs.sumOf { mapItOut(it, path + dir.name + "/") }

    sizes[path] = sum

    return sum
}

fun sumForPart1(dir: Dir): Int {
    var sum = 0

    sum += dir.files.sumOf { it.size }
    sum += dir.dirs.sumOf { sumForPart1(it) }

    if (sum <= 100000) sumOfDirsUnder100k += sum

    return sum
}

fun smallestToDelete(dir: Dir): Int {
    var sum = 0

    sum += dir.files.sumOf { it.size }
    sum += dir.dirs.sumOf { smallestToDelete(it) }

    if (sum > needToDeleteAtLeast && sum <= smallestYet) smallestYet = sum

    return sum
}

