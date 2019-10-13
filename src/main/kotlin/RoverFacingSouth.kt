class RoverFacingSouth(override val x: Int = 0, override val y: Int = 0, override val direction: String = NORTH) :
    MarsRover(x, y, direction) {
    override fun move(): MarsRover {
        val nextY = if (y.isUnderBoundary()) SIZE - 1 else y - 1
        return RoverFacingSouth(x, nextY, direction)
    }

    override fun rotateRight(): MarsRover {
        return RoverFacingWest(x, y, WEST)
    }

    override fun rotateLeft(): MarsRover {
        return RoverFacingEast(x, y, EAST)
    }
}