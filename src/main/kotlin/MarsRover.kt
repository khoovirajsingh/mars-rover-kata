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
            if (isNorthFacing()) moveNorth()
            if (isEastFacing()) moveEast()
            if (isSouthFacing()) moveSouth()
            if (isWestFacing()) moveWest()
        }
        return formattedPosition()
    }

    private fun moveWest() {
        if (x.isUnderBoundary()) x = SIZE - 1 else x--
    }

    private fun isNorthFacing() = cardinal == NORTH

    private fun moveNorth() {
        if (y.isOverBoundary()) y = 0 else y++
    }

    private fun isEastFacing() = cardinal == EAST

    private fun moveEast() {
        if (x.isOverBoundary()) x = 0 else x++
    }

    private fun isSouthFacing() = cardinal == SOUTH

    private fun moveSouth() {
        if (y.isUnderBoundary()) y = SIZE - 1 else y--
    }

    private fun isWestFacing() = cardinal == WEST

    private fun formattedPosition() = "$x:$y:$cardinal"
}
