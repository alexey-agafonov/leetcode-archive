class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val result = Array(m) { Array(n) {0} }
        result[0][0] = grid[0][0]

        // fill the first row
        for (i in 1 until n) {
            result[0][i] = result[0][i - 1] + grid[0][i]
        }

        // fill the first column
        for (i in 1 until m) {
            result[i][0] = result[i - 1][0] + grid[i][0]
        }

        // fill the remaining elements
        for (i in 1 until m) {
            for (j in 1 until n) {
                if (result[i - 1][j] > result[i][j - 1])
                    result[i][j] = result[i][j - 1] + grid[i][j]
                else
                    result[i][j] = result[i - 1][j] + grid[i][j]
            }
        }

        return result[m - 1][n - 1]
    }
}

fun main() {
    val solution = Solution()
    println(solution.minPathSum(arrayOf(intArrayOf(1, 3, 1),
                                        intArrayOf(1, 5, 1),
                                        intArrayOf(4, 2, 1))))
}