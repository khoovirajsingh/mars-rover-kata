private const val MOVE = 'M'
private const val ROTATE_RIGHT = 'R'
private const val ROTATE_LEFT = 'L'

class MarsRover(val grid: Grid, private var position: Position) {

    fun execute(commands: String): String {
        for (command in commands) {
            if (isMove(command)) position = position.move()
            if (isRotateRight(command)) position = position.rotateRight()
            if (isRotateLeft(command)) position = position.rotateLeft()
        }
        return position.toString()
    }

    private fun isMove(command: Char) = command == MOVE

    private fun isRotateRight(command: Char) = command == ROTATE_RIGHT

    private fun isRotateLeft(command: Char) = command == ROTATE_LEFT
}
