const val NORTH = "N"
const val EAST = "E"
const val SOUTH = "S"
const val WEST = "W"

data class Position(var x: Int = 0, var y: Int = 0, var direction: String = NORTH) {
    fun facing(cardinal: String) = cardinal == direction

    fun moveNorth() {
        if (y.isOverBoundary()) y = 0 else y++
    }

    fun moveSouth() {
        if (y.isUnderBoundary()) y = SIZE - 1 else y--
    }

    fun moveEast() {
        if (x.isOverBoundary()) x = 0 else x++
    }

    fun moveWest() {
        if (x.isUnderBoundary()) x = SIZE - 1 else x--
    }

    override fun toString() = "${x}:${y}:${direction}"
}