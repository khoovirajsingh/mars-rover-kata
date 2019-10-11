private const val NORTH = "N"
private const val EAST = "E"
private const val SOUTH = "S"

class MarsRover(val grid: Grid) {
    var cardinal: String = NORTH
    var y: Int = 0
    var x: Int = 0

    fun execute(commands: String): String {
        for (command in commands) {
            if (isNorthFacing()) moveNorth()
            if (isEastFacing()) moveEast()
            if (isSouthFacing()) moveSouth()
        }
        return formattedPosition()
    }

    private fun moveSouth() {
        if (y <= 0) y = 9 else y--
    }

    private fun isSouthFacing() = cardinal == SOUTH

    private fun isNorthFacing() = cardinal == NORTH

    private fun moveNorth() {
        if (y.isAtEdge()) y = 0 else y++
    }

    private fun isEastFacing() = cardinal == EAST

    private fun moveEast() {
        if (x.isAtEdge()) x = 0 else x++
    }

    private fun formattedPosition() = "$x:$y:$cardinal"
}
