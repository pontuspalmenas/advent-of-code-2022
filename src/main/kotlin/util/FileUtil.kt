package util

import java.io.File

class FileUtil(val path: String) {
    fun lines(): List<String> = File(path).readLines()
    fun text(): String = File(path).readText()
    fun blocks(): List<List<String>> = File(path).readText().split("\n\n").map { it.split("\n") }
    fun intBlocks(): List<List<Int>> = blocks().map { x -> x.map { Integer.parseInt(it) } }
}