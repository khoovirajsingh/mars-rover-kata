class MarsRover(val grid: Grid) {
    var cardinal: String = "N"
    var y: Int = 0
    var x: Int = 0

    fun execute(commands: String): String {
        for (command in commands) {
            if (cardinal == "N") moveNorth()
            if (cardinal == "E") moveEast()
        }
        return formattedPosition()
    }

    private fun moveEast() {
        x++
    }

    private fun moveNorth() {
        if (y.isAtEdge()) y = 0 else y++
    }

    private fun formattedPosition() = "$x:$y:$cardinal"
}
