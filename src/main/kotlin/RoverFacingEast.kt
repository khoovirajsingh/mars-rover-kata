class RoverFacingEast(override val x: Int = 0, override val y: Int = 0, override val direction: String = NORTH) :
    MarsRover(x, y, direction) {
    override fun move(): MarsRover {
        val nextX = if (x.isOverBoundary()) 0 else x + 1
        return RoverFacingEast(nextX, y, direction)
    }

    override fun rotateRight(): MarsRover {
        return RoverFacingSouth(x, y, SOUTH)
    }

    override fun rotateLeft(): MarsRover {
        return RoverFacingNorth(x, y, NORTH)
    }
}