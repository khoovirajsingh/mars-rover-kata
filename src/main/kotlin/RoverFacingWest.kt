class RoverFacingWest(override val x: Int = 0, override val y: Int = 0, override val direction: String = NORTH) :
    MarsRover(x, y, direction) {
    override fun move(): MarsRover {
        val nextX = if (x.isUnderBoundary()) SIZE - 1 else x - 1
        return RoverFacingWest(nextX, y, direction)
    }

    override fun rotateRight(): MarsRover {
        return RoverFacingNorth(x, y, NORTH)
    }

    override fun rotateLeft(): MarsRover {
        return RoverFacingSouth(x, y, SOUTH)
    }
}