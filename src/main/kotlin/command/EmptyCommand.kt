package command

import rover.Rover

class EmptyCommand(private val rover: Rover)  : Command {
    override fun execute(): Rover {
        return rover
    }
}
