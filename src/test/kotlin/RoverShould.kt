import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class RoverShould {
    @Test
    fun `have a description`() {
        Rover().toString() `should be equal to` "0:0:N"
    }
}