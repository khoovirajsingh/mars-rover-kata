const val NORTH = "N"
const val EAST = "E"
const val SOUTH = "S"
const val WEST = "W"

data class Position(var x: Int = 0, var y: Int = 0, var direction: String = NORTH) {
    fun facing(cardinal: String) = cardinal == direction

    override fun toString() = "${x}:${y}:${direction}"
}