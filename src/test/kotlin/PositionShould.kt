import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class PositionShould {
    @Test
    fun `have a description`() {
        Position().toString() `should be equal to` "0:0:N"
    }
}