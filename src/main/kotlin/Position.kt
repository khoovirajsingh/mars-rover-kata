const val NORTH = "N"
const val EAST = "E"
const val SOUTH = "S"
const val WEST = "W"

data class Position(val x: Int = 0, val y: Int = 0, val direction: String = NORTH) {

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
        val nextY = if (y.isOverBoundary()) 0 else y + 1
        return Position(x, nextY, direction)
    }

    private fun moveSouth(): Position {
        val nextY = if (y.isUnderBoundary()) SIZE - 1 else y - 1
        return Position(x, nextY, direction)
    }

    private fun moveEast(): Position {
        val nextX = if (x.isOverBoundary()) 0 else x + 1
        return Position(nextX, y, direction)
    }

    private fun moveWest(): Position {
        val nextX = if (x.isUnderBoundary()) SIZE - 1 else x - 1
        return Position(nextX, y, direction)
    }

    override fun toString() = "${x}:${y}:${direction}"
}