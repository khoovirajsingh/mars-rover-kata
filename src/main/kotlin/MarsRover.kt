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
        if (facing(NORTH)) position.moveNorth()
        if (facing(EAST)) position.moveEast()
        if (facing(SOUTH)) position.moveSouth()
        if (facing(WEST)) position.moveWest()
    }

    private fun facing(direction: String) = position.facing(direction)

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
