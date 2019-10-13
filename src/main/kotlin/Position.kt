const val NORTH = "N"
const val EAST = "E"
const val SOUTH = "S"
const val WEST = "W"

data class Position(var x: Int = 0, var y: Int = 0, var direction: String = NORTH) {

    fun move(): Position {
        if (facing(NORTH)) return moveNorth()
        if (facing(EAST)) return moveEast()
        if (facing(SOUTH)) return moveSouth()
        if (facing(WEST)) return moveWest()
        return Position(x, y, direction)
    }

    fun rotateRight(): Position {
        return when {
            facing(NORTH) -> Position(x, y, EAST)
            facing(EAST) -> Position(x, y, SOUTH)
            facing(SOUTH) -> Position(x, y, WEST)
            facing(WEST) -> Position(x, y, NORTH)
            else -> Position(x, y, direction)
        }
    }

    fun rotateLeft(): Position {
        return when {
            facing(NORTH) -> Position(x, y, WEST)
            facing(WEST) -> Position(x, y, SOUTH)
            facing(SOUTH) -> Position(x, y, EAST)
            facing(EAST) -> Position(x, y, NORTH)
            else -> Position(x, y, direction)
        }
    }

    private fun facing(cardinal: String) = cardinal == direction

    private fun moveNorth(): Position {
        if (y.isOverBoundary()) y = 0 else y++
        return Position(x, y, direction)
    }

    private fun moveSouth(): Position {
        if (y.isUnderBoundary()) y = SIZE - 1 else y--
        return Position(x, y, direction)
    }

    private fun moveEast(): Position {
        if (x.isOverBoundary()) x = 0 else x++
        return Position(x, y, direction)
    }

    private fun moveWest(): Position {
        if (x.isUnderBoundary()) x = SIZE - 1 else x--
        return Position(x, y, direction)
    }

    override fun toString() = "${x}:${y}:${direction}"
}