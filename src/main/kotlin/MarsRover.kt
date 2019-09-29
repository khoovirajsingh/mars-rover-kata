class MarsRover(grid: Grid) {
    var cardinal: String = "N"
    var y: Int = 0
    var x: Int = 0

    fun execute(commands: String): String {
        for (command in commands) {
            y++
        }
        return formattedPosition()
    }

    private fun formattedPosition() = "$x:$y:$cardinal"
}
