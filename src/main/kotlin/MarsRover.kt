class MarsRover(grid: Grid) {
    var cardinal: String = "N"
    var y: Int = 0
    var x: Int = 0

    fun execute(command: String): String {
        if (command.isNotEmpty()) {
            y++
        }
        return formattedPosition()
    }

    private fun formattedPosition() = "$x:$y:$cardinal"
}
