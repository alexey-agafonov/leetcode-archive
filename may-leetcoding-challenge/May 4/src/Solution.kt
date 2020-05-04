import kotlin.math.floor
import kotlin.math.ln

class Solution {
    fun findComplement(num: Int): Int {
        val numberOfBits = floor(ln(num.toDouble()) / ln(2.0)).toInt() + 1

        return (1 shl numberOfBits) - 1 xor num
    }
}

fun main() {
    val solution = Solution()
    println(solution.findComplement(5))
    println(solution.findComplement(1))
    println(solution.findComplement(196))
}