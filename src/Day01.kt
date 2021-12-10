fun main() {
    fun part1(input: List<Int>): Int {
        return input.windowed(size = 2).count { (a, b) -> a < b }
    }

    fun part2(input: List<Int>): Int {
        return input.windowed(size = 3).windowed(size = 2).count { (a, b) ->  a.sum() < b.sum() }
    }

    val input = readInputAsInts("Day01")
    println(part1(input))
    println(part2(input))
}
