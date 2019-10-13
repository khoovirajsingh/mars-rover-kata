private const val MOVE = 'M'
private const val ROTATE_RIGHT = 'R'
private const val ROTATE_LEFT = 'L'

class MarsRoverCommand(val grid: Grid, private var rover: Rover) {

    fun execute(commands: String): String {
        for (command in commands) {
            if (isMove(command)) rover = rover.move()
            if (isRotateRight(command)) rover = rover.rotateRight()
            if (isRotateLeft(command)) rover = rover.rotateLeft()
        }
        return rover.toString()
    }

    private fun isMove(command: Char) = command == MOVE

    private fun isRotateRight(command: Char) = command == ROTATE_RIGHT

    private fun isRotateLeft(command: Char) = command == ROTATE_LEFT
}
