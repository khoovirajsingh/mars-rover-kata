const val NORTH = "N"
const val EAST = "E"
const val SOUTH = "S"
const val WEST = "W"

abstract class MarsRover(open val x: Int = 0, open val y: Int = 0, open val direction: String = NORTH) {
    abstract fun move(): MarsRover

    abstract fun rotateRight(): MarsRover

    abstract fun rotateLeft(): MarsRover

    override fun toString() = "${x}:${y}:${direction}"
}