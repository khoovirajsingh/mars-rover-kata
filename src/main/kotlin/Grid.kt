const val SIZE = 10

class Grid

fun Int.isOverBoundary() = this == SIZE-1
fun Int.isUnderBoundary() = this <= 0
