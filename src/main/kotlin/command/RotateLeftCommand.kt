package command

import rover.Rover

class RotateLeftCommand(private val rover: Rover) : Command {
    override fun execute(): Rover {
        return rover.rotateLeft()
    }
}