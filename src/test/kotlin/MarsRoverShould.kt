import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

private const val EMPTY_COMMAND = ""

class MarsRoverShould {
    lateinit var grid: Grid
    lateinit var marsRover: MarsRover

    @BeforeEach
    fun setUp() {
        grid = Grid()
        marsRover = MarsRover(grid)
    }

    @ParameterizedTest
    @CsvSource(
            "0, 0, N, '0:0:N'",
            "5, 6, W, '5:6:W'"
    )
    fun `stay at the same position given an empty command`(x: Int, y: Int, cardinal: String, expectedPosition:String) {
        marsRover.x = x
        marsRover.y = y
        marsRover.cardinal = cardinal

        val actualPosition = marsRover.execute(EMPTY_COMMAND)

        actualPosition `should be equal to` expectedPosition
    }
}