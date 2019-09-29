import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class MarsRoverShould {
    @Test
    fun move() {
        val grid = Grid()
        val marsRover = MarsRover(grid)
        val position = marsRover.execute("")
        position `should be equal to` "0:0:N"
    }
}