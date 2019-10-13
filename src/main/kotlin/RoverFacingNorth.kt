class RoverFacingNorth(override val x: Int = 0, override val y: Int = 0, override val direction: String = NORTH) :
    MarsRover(x, y, direction) {
    override fun move(): MarsRover {
        val nextY = if (y.isOverBoundary()) 0 else y + 1
        return RoverFacingNorth(x, nextY, direction)
    }

    override fun rotateRight() = RoverFacingEast(x, y, EAST)

    override fun rotateLeft() = RoverFacingWest(x, y, WEST)
}


