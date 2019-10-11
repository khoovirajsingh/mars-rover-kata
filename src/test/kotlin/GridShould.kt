import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test

class GridShould {
    @Test
    fun `validate if position is at edge grid boundary`() {
        9.isOverBoundary() `should be equal to` true
        0.isUnderBoundary() `should be equal to` true
    }
}