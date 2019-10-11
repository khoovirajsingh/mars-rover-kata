import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

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
    fun `stay at the same position given an empty command`(x: Int, y: Int, cardinal: String, expectedPosition: String) {
        marsRover.x = x
        marsRover.y = y
        marsRover.cardinal = cardinal

        val actualPosition = marsRover.execute("")

        actualPosition `should be equal to` expectedPosition
    }

    @ParameterizedTest
    @CsvSource(
        "0, 0, N, M, '0:1:N'",
        "0, 0, N, MM, '0:2:N'",
        "0, 0, N, MMMMMMMMMM, '0:0:N'",
        "0, 0, N, MMMMMMMMMMM, '0:1:N'",
        "0, 0, E, M, '1:0:E'",
        "0, 0, E, MMMMMMMMMMM, '1:0:E'",
        "0, 9, S, M, '0:8:S'",
        "0, 0, S, M, '0:9:S'",
        "9, 0, W, M, '8:0:W'",
        "0, 0, W, M, '9:0:W'"
    )
    fun move(x: Int, y: Int, cardinal: String, command: String, expectedPosition: String) {
        marsRover.x = x
        marsRover.y = y
        marsRover.cardinal = cardinal

        val actualPosition = marsRover.execute(command)

        actualPosition `should be equal to` expectedPosition
    }
}