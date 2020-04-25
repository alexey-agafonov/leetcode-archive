import kotlin.math.max

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var pos = 0
        var i = 0

        while (i <= pos) {
            pos = max(pos,nums[i] + i)
            i++
            if (pos >= nums.size - 1) return true
        }

        return false
    }
}

fun main() {
    val solution = Solution()
    println(solution.canJump(intArrayOf(2, 3, 1, 1, 4)))
    println(solution.canJump(intArrayOf(3, 1, 1, 0, 4)))
    println(solution.canJump(intArrayOf(2, 0)))
    println(solution.canJump(intArrayOf(2, 5, 0, 0)))
    println(solution.canJump(intArrayOf(2, 0, 0)))
    println(solution.canJump(intArrayOf(3, 0, 8, 2, 0, 0, 1)))
}