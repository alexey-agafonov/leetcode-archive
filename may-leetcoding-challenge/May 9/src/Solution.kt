class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        var step = 1
        var remainder = num

        while (remainder >= 0) {
            if (remainder == 0) return true

            remainder -= step
            step += 2
        }

        return false
    }
}

fun main() {
    val solution = Solution()
    println(solution.isPerfectSquare(16))
    println(solution.isPerfectSquare(14))
}