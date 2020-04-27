import kotlin.math.max
import kotlin.math.min

class Solution {

    fun maximalSquare(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty()) {
            return 0
        }

        var result = 0
        val dp = Array(matrix.size) { IntArray(matrix[0].size) }

        for (i in matrix.indices) {
            dp[i][0] = matrix[i][0] - '0'
            result = max(result, dp[i][0])
        }
        
        for (j in matrix[0].indices) {
            dp[0][j] = matrix[0][j] - '0'
            result = max(result, dp[0][j])
        }

        for (i in 1 until matrix.size) {
            for (j in 1 until matrix[0].size) {
                if (matrix[i][j] == '1') {
                    var min = min(dp[i - 1][j], dp[i][j - 1])
                    min = min(min, dp[i - 1][j - 1])
                    dp[i][j] = min + 1
                    result = max(result, min + 1)
                } else {
                    dp[i][j] = 0
                }
            }
        }

        return result * result
    }
}

fun main() {
    val solution = Solution()
    println(solution.maximalSquare(arrayOf(charArrayOf('1', '0', '1', '0', '0'),
                                           charArrayOf('1', '0', '1', '1', '1'),
                                           charArrayOf('1', '1', '1', '1', '1'),
                                           charArrayOf('1', '0', '0', '1', '0'))))
}