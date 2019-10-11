import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class GridShould {
    @Test
    fun `validate if position is outside of grid boundary`() {
        10.isWithinGrid() `should be equal to` true
    }
}