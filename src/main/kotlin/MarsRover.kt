private const val START_POSITION = 0
class MarsRover(val grid: Grid) {
    var cardinal: String = "N"
    var y: Int = START_POSITION
    var x: Int = START_POSITION

    fun execute(commands: String): String {
        for (command in commands) {
            moveNorth()
        }
        return formattedPosition()
    }

    private fun moveNorth() {
        if (y.isWithinGrid()) y = START_POSITION else y++
    }

    private fun formattedPosition() = "$x:$y:$cardinal"
}
