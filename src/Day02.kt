fun main() {
    fun part1(input: List<String>): Int {
        var depth = 0
        var horizontalPosition = 0
        val operations = input.map { it.split(' ') }

        for ((direction, amountString) in operations){
            val amount = amountString.toInt()
            when (direction){
                "forward" -> horizontalPosition += amount
                "down" -> depth += amount
                "up" -> depth -= amount
            }
        }

        return depth.times(horizontalPosition)
    }

    fun part2(input: List<String>): Int {
        var depth = 0
        var horizontalPosition = 0
        var aim = 0
        val operations = input.map { it.split(' ') }

        for ((direction, amountString) in operations){
            val amount = amountString.toInt()
            when (direction){
                "forward" -> {
                    horizontalPosition += amount
                    depth += aim.times(amount)
                }
                "down" -> {
                    aim += amount
                }
                "up" -> {
                    aim -= amount
                }
            }
        }

        return depth.times(horizontalPosition)
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
