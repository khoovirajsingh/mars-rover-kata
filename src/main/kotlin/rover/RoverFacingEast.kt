package rover

import isOverBoundary

class RoverFacingEast(override val x: Int = 0, override val y: Int = 0, override val direction: String = NORTH) :
    Rover(x, y, direction) {
    override fun move(): Rover {
        val nextX = if (x.isOverBoundary()) 0 else x + 1
        return RoverFacingEast(nextX, y, direction)
    }

    override fun rotateRight(): Rover {
        return RoverFacingSouth(x, y, SOUTH)
    }

    override fun rotateLeft(): Rover {
        return RoverFacingNorth(x, y, NORTH)
    }
}