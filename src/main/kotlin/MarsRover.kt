private const val MOVE = 'M'
private const val ROTATE_RIGHT = 'R'
class MarsRover(val grid: Grid, var position: Position) {

    fun execute(commands: String): String {
        for (command in commands) {
            if (isMove(command)) move()
            if (isRotateRight(command)) rotateRight()
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
        if (facing(NORTH)) position.direction = EAST
        else if (facing(EAST)) position.direction = SOUTH
    }
}
