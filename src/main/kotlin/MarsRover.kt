import command.createCommand
import rover.Rover

class MarsRover(val grid: Grid, private var rover: Rover) {
    fun execute(commands: String): String {
        for (command in commands) {
            rover = createCommand(command, rover).execute()
        }
        return rover.toString()
    }
}
