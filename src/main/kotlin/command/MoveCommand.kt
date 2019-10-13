package command

import rover.Rover

class MoveCommand(private val rover: Rover) : Command {
    override fun execute(): Rover {
        return rover.move()
    }
}