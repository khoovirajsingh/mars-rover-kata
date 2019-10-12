private const val MOVE = 'M'
class MarsRover(val grid: Grid, val position: Position) {

    fun execute(commands: String): String {
        for (command in commands) {
            if (isMove(command)) move()
        }
        return position.toString()
    }

    private fun isMove(command: Char) = command == MOVE

    private fun move() {
        if (position.facing(NORTH)) moveNorth()
        if (position.facing(EAST)) moveEast()
        if (position.facing(SOUTH)) moveSouth()
        if (position.facing(WEST)) moveWest()
    }

    private fun moveWest() {
        if (position.x.isUnderBoundary()) position.x = SIZE - 1 else position.x--
    }

    private fun moveNorth() {
        if (position.y.isOverBoundary()) position.y = 0 else position.y++
    }

    private fun moveEast() {
        if (position.x.isOverBoundary()) position.x = 0 else position.x++
    }

    private fun moveSouth() {
        if (position.y.isUnderBoundary()) position.y = SIZE - 1 else position.y--
    }
}
