package util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionTest {

    @Test
    fun someTest() {
        var p = Position(5, 5)
        p = p.move(Direction.N, 3)
        p = p.move(Direction.S, 2)
        p = p.move(Direction.S, 1)
        p = p.move(Direction.NE, 2)
        p = p.move(Direction.SW, 2)

        assertEquals(Position(5, 5), p)
    }
}