import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Reads lines from the given input txt file as integers.
 */
fun readInputAsInts(name: String) = File("src", "$name.txt").readLines().map { it.toInt() }

/**
 * Reads lines from the given input txt file as integers.
 */
fun readInputAsCharArray(name: String) = File("src", "$name.txt").readLines().map { it.toCharArray() }

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
