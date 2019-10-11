private const val NORTH = "N"
private const val EAST = "E"

class MarsRover(val grid: Grid) {
    var cardinal: String = NORTH
    var y: Int = 0
    var x: Int = 0

    fun execute(commands: String): String {
        for (command in commands) {
            if (isNorthFacing()) moveNorth()
            if (isEastFacing()) moveEast()
        }
        return formattedPosition()
    }

    private fun isNorthFacing() = cardinal == NORTH

    private fun moveNorth() {
        if (y.isAtEdge()) y = 0 else y++
    }

    private fun isEastFacing() = cardinal == EAST

    private fun moveEast() {
        x++
    }

    private fun formattedPosition() = "$x:$y:$cardinal"
}
