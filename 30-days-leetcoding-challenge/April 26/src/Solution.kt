import kotlin.math.max

class Solution {
    fun longestCommonSubsequence(text: String, substring: String): Int {
        var height = text.length
        var width = substring.length
        val diffs = Array(height + 1) { IntArray(width + 1) {0} }

        for (i in 0..height) {
            for (j in 0..width) {
                if (i == 0 || j == 0)
                    diffs[i][j] = 0
                else if (text[i - 1] == substring[j - 1])
                    diffs[i][j] = diffs[i - 1][j - 1] + 1
                else
                    diffs[i][j] = max(diffs[i - 1][j], diffs[i][j - 1])
            }
        }

        return diffs[height][width]
    }
}

fun main() {
    val solution = Solution()
    println(solution.longestCommonSubsequence("abcde", "ace"))
    println(solution.longestCommonSubsequence("abc", "abc"))
    println(solution.longestCommonSubsequence("abc", "def"))
}