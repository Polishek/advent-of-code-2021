import kotlin.math.pow

fun main() {
    fun part1(input: List<String>): Int {

        var gammaRate = 0
        var epsilonRate = 0
        var correctBit : Int
        val binaryLength = input.get(1).length

        for(i in 0 until binaryLength){
            correctBit = 0

            for(binary in input){
                if(binary[i] == '1'){
                    correctBit++
                }
            }

            if ( (input.size - correctBit) < correctBit ){
                gammaRate += 2.0.pow(binaryLength - 1 - i).toInt()
            }
            else{
                epsilonRate += 2.0.pow(binaryLength - 1 - i).toInt()
            }
        }

        return gammaRate * epsilonRate
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
