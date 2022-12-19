package day07

import util.FileUtil

fun main(args: Array<String>) {
    val l = FileUtil("input/day07.txt").lines()
    println(solve1(l))
    //println(solve2(l))
}

fun solve1(l: List<String>): Int {
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

    //fs.printTree()

    //fs.calcThatWeirdSumBro(fs.root)
    //return fs.sumOfDirsLessThan10kTotal

    return totalSize(fs.root)
}

fun totalSize(dir: Dir): Int {
    var sum = 0

    sum += dir.files.sumOf { it.size }
    sum += dir.dirs.sumOf { totalSize(it) }

    //println("${dir.name}: $sum")

    if (sum < 10000) {
        println("$sum")
    }

    return sum
}

