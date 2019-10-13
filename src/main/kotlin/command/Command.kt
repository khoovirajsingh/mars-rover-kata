package command

import rover.Rover

interface Command {
    fun execute(): Rover
}

fun createCommand(command: Char, rover: Rover): Command {
    return when (command) {
        'M' -> MoveCommand(rover)
        'L' -> RotateLeftCommand(rover)
        'R' -> RotateRightCommand(rover)
        else -> EmptyCommand(rover)
    }
}