class MarsRover(val grid: Grid, val position: Position) {

    fun execute(commands: String): String {
        for (command in commands) {
            if (position.facing(NORTH)) moveNorth()
            if (position.facing(EAST)) moveEast()
            if (position.facing(SOUTH)) moveSouth()
            if (position.facing(WEST)) moveWest()
        }
        return position.toString()
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
