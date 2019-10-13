package rover

import SIZE
import isUnderBoundary

class RoverFacingSouth(override val x: Int = 0, override val y: Int = 0, override val direction: String = NORTH) :
    Rover(x, y, direction) {
    override fun move(): Rover {
        val nextY = if (y.isUnderBoundary()) SIZE - 1 else y - 1
        return RoverFacingSouth(x, nextY, direction)
    }

    override fun rotateRight(): Rover {
        return RoverFacingWest(x, y, WEST)
    }

    override fun rotateLeft(): Rover {
        return RoverFacingEast(x, y, EAST)
    }
}