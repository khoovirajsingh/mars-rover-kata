package command

import rover.Rover

class RotateRightCommand(private val rover: Rover) : Command {
    override fun execute(): Rover {
        return rover.rotateRight()
    }
}