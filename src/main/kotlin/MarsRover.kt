private const val NORTH = "N"
private const val EAST = "E"
private const val SOUTH = "S"
private const val WEST = "W"

class MarsRover(val grid: Grid) {
    var cardinal: String = NORTH
    var y: Int = 0
    var x: Int = 0

    fun execute(commands: String): String {
        for (command in commands) {
            if (facing(NORTH)) moveNorth()
            if (facing(EAST)) moveEast()
            if (facing(SOUTH)) moveSouth()
            if (facing(WEST)) moveWest()
        }
        return formattedPosition()
    }

    private fun facing(direction: String) = cardinal == direction

    private fun moveWest() {
        if (x.isUnderBoundary()) x = SIZE - 1 else x--
    }

    private fun moveNorth() {
        if (y.isOverBoundary()) y = 0 else y++
    }

    private fun moveEast() {
        if (x.isOverBoundary()) x = 0 else x++
    }

    private fun moveSouth() {
        if (y.isUnderBoundary()) y = SIZE - 1 else y--
    }

    private fun formattedPosition() = "$x:$y:$cardinal"
}
