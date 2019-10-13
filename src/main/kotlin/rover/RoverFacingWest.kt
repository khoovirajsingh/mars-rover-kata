package rover

import SIZE
import isUnderBoundary

class RoverFacingWest(override val x: Int = 0, override val y: Int = 0, override val direction: String = NORTH) :
    Rover(x, y, direction) {
    override fun move(): Rover {
        val nextX = if (x.isUnderBoundary()) SIZE - 1 else x - 1
        return RoverFacingWest(nextX, y, direction)
    }

    override fun rotateRight(): Rover {
        return RoverFacingNorth(x, y, NORTH)
    }

    override fun rotateLeft(): Rover {
        return RoverFacingSouth(x, y, SOUTH)
    }
}