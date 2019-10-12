private const val MOVE = 'M'
private const val ROTATE_RIGHT = 'R'
private const val ROTATE_LEFT = 'L'
class MarsRover(val grid: Grid, var position: Position) {

    fun execute(commands: String): String {
        for (command in commands) {
            if (isMove(command)) move()
            if (isRotateRight(command)) rotateRight()
            if (isRotateLeft(command)) rotateLeft()
        }
        return position.toString()
    }

    private fun isMove(command: Char) = command == MOVE

    private fun move() {
        if (facing(NORTH)) moveNorth()
        if (facing(EAST)) moveEast()
        if (facing(SOUTH)) moveSouth()
        if (facing(WEST)) moveWest()
    }

    private fun facing(direction: String) = position.facing(direction)

    private fun moveNorth() {
        if (position.y.isOverBoundary()) position.y = 0 else position.y++
    }

    private fun moveEast() {
        if (position.x.isOverBoundary()) position.x = 0 else position.x++
    }

    private fun moveSouth() {
        if (position.y.isUnderBoundary()) position.y = SIZE - 1 else position.y--
    }

    private fun moveWest() {
        if (position.x.isUnderBoundary()) position.x = SIZE - 1 else position.x--
    }

    private fun isRotateRight(command: Char) = command == ROTATE_RIGHT

    private fun rotateRight() {
        when {
            facing(NORTH) -> position.direction = EAST
            facing(EAST) -> position.direction = SOUTH
            facing(SOUTH) -> position.direction = WEST
            facing(WEST) -> position.direction = NORTH
        }
    }

    private fun isRotateLeft(command: Char) = command == ROTATE_LEFT

    private fun rotateLeft() {
        when {
            facing(NORTH) -> position.direction = WEST
            facing(WEST) -> position.direction = SOUTH
            facing(SOUTH) -> position.direction = EAST
            facing(EAST) -> position.direction = NORTH
        }
    }
}
