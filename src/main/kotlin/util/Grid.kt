package util

import java.lang.IllegalStateException

// Inspired by https://github.com/saidaspen/adventofkotlin/blob/main/src/main/kotlin/se/saidaspen/aoc/util/Grid.kt
// Kotlin doesn't really like primitive arrays, so this is a great alternative.
class Grid<T>(val default: T) {
    val width: Int
        get() = if(grid.size == 0) 0 else grid[0].size

    val height: Int
        get() = grid.size

    fun size() = width * height

    private var grid: MutableList<MutableList<T>> = mutableListOf()

    operator fun set(x: Int, y: Int, value: T) {
        // Original does expand if OOB. I don't trust myself that much.
        if (x >= width || y >= height || x < 0 || y < 0) {
            throw IllegalStateException("Grid out of bounds: ($x,$y) does not fit in ($width,$height)")
        }

        grid[y][x] = value
    }

}