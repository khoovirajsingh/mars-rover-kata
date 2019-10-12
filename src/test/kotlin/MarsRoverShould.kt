import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MarsRoverShould {
    private lateinit var grid: Grid
    private lateinit var marsRover: MarsRover

    @BeforeEach
    fun setUp() {
        grid = Grid()
    }

    @ParameterizedTest
    @CsvSource(
        "0, 0, N, X, '0:0:N'",
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
    fun move(x: Int, y: Int, direction: String, command: String, expectedPosition: String) {
        marsRover = MarsRover(grid, Position(x, y, direction))

        val actualPosition = marsRover.execute(command)

        actualPosition `should be equal to` expectedPosition
    }

    @ParameterizedTest
    @CsvSource(
        "0, 0, N, R, '0:0:E'",
        "0, 0, N, RR, '0:0:S'",
        "0, 0, N, RRR, '0:0:W'",
        "0, 0, N, RRRR, '0:0:N'",
        "0, 0, N, L, '0:0:W'",
        "0, 0, N, LL, '0:0:S'",
        "0, 0, N, LLL, '0:0:E'",
        "0, 0, N, LLLL, '0:0:N'"
    )
    fun rotate(x: Int, y: Int, direction: String, command: String, expectedPosition: String) {
        marsRover = MarsRover(grid, Position(x, y, direction))

        val actualPosition = marsRover.execute(command)

        actualPosition `should be equal to` expectedPosition
    }
}