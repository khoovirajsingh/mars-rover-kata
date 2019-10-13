package rover

const val NORTH = "N"
const val EAST = "E"
const val SOUTH = "S"
const val WEST = "W"

abstract class Rover(open val x: Int = 0, open val y: Int = 0, open val direction: String = NORTH) {
    abstract fun move(): Rover

    abstract fun rotateRight(): Rover

    abstract fun rotateLeft(): Rover

    override fun toString() = "${x}:${y}:${direction}"
}