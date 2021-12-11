import kotlin.math.pow

fun main() {
    fun part1(input: List<String>): Int {

        var gammaRate = 0
        var epsilonRate = 0
        var correctBit: Int
        val binaryLength = input[1].length

        for (i in 0 until binaryLength) {
            correctBit = 0

            for (binary in input) {
                if (binary[i] == '1') {
                    correctBit++
                }
            }

            if ((input.size - correctBit) < correctBit) {
                gammaRate += 2.0.pow(binaryLength - 1 - i).toInt()
            } else {
                epsilonRate += 2.0.pow(binaryLength - 1 - i).toInt()
            }
        }

        return gammaRate * epsilonRate
    }

    fun part2(input: List<String>): Int {
        var oxygenRatingValue = 0
        var co2RatingValue = 0
        val inputOxygen = input.toMutableList()
        val inputCO2 = input.toMutableList()
        var correctBit: Int
        val binaryLength = input[1].length

        for (i in 0 until binaryLength) {

            //================ OXYGEN PART ================
            correctBit = 0

            for (binary in inputOxygen) {
                if (binary[i] == '1') {
                    correctBit++
                }
            }

            /*Condition checks whether there is more '1' or '0' and removing mismatched elements in the list Oxygen*/
            if ((inputOxygen.size - correctBit) <= correctBit) {
                inputOxygen.removeIf { binary -> binary[i] == '0' }

                oxygenRatingValue += 2.0.pow(binaryLength - 1 - i).toInt()
            } else {

                inputOxygen.removeIf { binary -> binary[i] == '1' }
            }

            //================ CO2 PART ================
            //block of code executes only if length of inputCO2 > 1
            correctBit = 0

            for (binary in inputCO2) {
                if (binary[i] == '1') {
                    correctBit++
                }
            }

            if (!inputCO2.size.equals(1)) {
                /*Condition checks whether there is more '1' or '0' and removing mismatched elements in the list CO2*/
                if ((inputCO2.size - correctBit) <= correctBit) {
                    inputCO2.removeIf { word -> word[i] == '1' }
                    //oxygenRatingValue += 2.0.pow(binaryLength - 1 - i).toInt()
                } else {
                    inputCO2.removeIf { word -> word[i] == '0' }

                    co2RatingValue += 2.0.pow(binaryLength - 1 - i).toInt()
                }
            } else {
                /* If there is only one element in the list CO2, continue calculating CO2RatingValue only*/
                if (inputCO2[0].get(i) == '1') {
                    co2RatingValue += 2.0.pow(binaryLength - 1 - i).toInt()
                }
            }
        }

        return oxygenRatingValue * co2RatingValue
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
