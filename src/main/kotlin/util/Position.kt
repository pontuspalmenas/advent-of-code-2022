package util

import util.Direction.*

data class Position(val x: Int, val y: Int) {
    fun move(dir: Direction, distance: Int = 1): Position {
        return when (dir) {
            N -> this.plus(0,-1*distance)
            E -> this.plus(1*distance,0)
            S -> this.plus(0,1*distance)
            W -> this.plus(-1*distance,0)
            NE -> this.plus(1*distance,-1*distance)
            NW -> this.plus(-1*distance,-1*distance)
            SE -> this.plus(1*distance,1*distance)
            SW -> this.plus(1*distance,-1*distance)
        }
    }

    fun plus(x2: Int, y2: Int): Position {
        return Position(x+x2, y+y2)
    }
}