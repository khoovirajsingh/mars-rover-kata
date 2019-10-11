import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class GridShould {
    @Test
    fun `validate if position is at edge grid boundary`() {
        9.isAtEdge() `should be equal to` true
    }
}