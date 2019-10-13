const val NORTH = "N"
const val EAST = "E"
const val SOUTH = "S"
const val WEST = "W"

data class Position(var x: Int = 0, var y: Int = 0, var direction: String = NORTH) {
    fun facing(cardinal: String) = cardinal == direction

    fun moveNorth(): Position {
        if (y.isOverBoundary()) y = 0 else y++
        return Position(x, y, direction)
    }

    fun moveSouth(): Position {
        if (y.isUnderBoundary()) y = SIZE - 1 else y--
        return Position(x, y, direction)
    }

    fun moveEast(): Position {
        if (x.isOverBoundary()) x = 0 else x++
        return Position(x, y, direction)
    }

    fun moveWest(): Position {
        if (x.isUnderBoundary()) x = SIZE - 1 else x--
        return Position(x, y, direction)
    }

    override fun toString() = "${x}:${y}:${direction}"
}