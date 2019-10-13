const val NORTH = "N"
const val EAST = "E"
const val SOUTH = "S"
const val WEST = "W"

data class Rover(val x: Int = 0, val y: Int = 0, val direction: String = NORTH) {

    fun move(): Rover {
        if (facing(NORTH)) return moveNorth()
        if (facing(EAST)) return moveEast()
        if (facing(SOUTH)) return moveSouth()
        if (facing(WEST)) return moveWest()
        return Rover(x, y, direction)
    }

    fun rotateRight(): Rover {
        return when {
            facing(NORTH) -> Rover(x, y, EAST)
            facing(EAST) -> Rover(x, y, SOUTH)
            facing(SOUTH) -> Rover(x, y, WEST)
            facing(WEST) -> Rover(x, y, NORTH)
            else -> Rover(x, y, direction)
        }
    }

    fun rotateLeft(): Rover {
        return when {
            facing(NORTH) -> Rover(x, y, WEST)
            facing(WEST) -> Rover(x, y, SOUTH)
            facing(SOUTH) -> Rover(x, y, EAST)
            facing(EAST) -> Rover(x, y, NORTH)
            else -> Rover(x, y, direction)
        }
    }

    private fun facing(cardinal: String) = cardinal == direction

    private fun moveNorth(): Rover {
        val nextY = if (y.isOverBoundary()) 0 else y + 1
        return Rover(x, nextY, direction)
    }

    private fun moveSouth(): Rover {
        val nextY = if (y.isUnderBoundary()) SIZE - 1 else y - 1
        return Rover(x, nextY, direction)
    }

    private fun moveEast(): Rover {
        val nextX = if (x.isOverBoundary()) 0 else x + 1
        return Rover(nextX, y, direction)
    }

    private fun moveWest(): Rover {
        val nextX = if (x.isUnderBoundary()) SIZE - 1 else x - 1
        return Rover(nextX, y, direction)
    }

    override fun toString() = "${x}:${y}:${direction}"
}