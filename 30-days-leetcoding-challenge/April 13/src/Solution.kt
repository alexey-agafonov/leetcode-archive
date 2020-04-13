import kotlin.math.max

class Solution {

    fun findMaxLength(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        for (i in nums.indices) {
            if (nums[i] == 0) nums[i] = -1
        }

        val map: MutableMap<Int, Int> = HashMap()
        map[0] = -1
        var sum = 0
        var max = 0
        for (i in nums.indices) {
            sum += nums[i]
            if (map.containsKey(sum)) {
                max = max(max, i - map[sum]!!)
            }
            if (!map.containsKey(sum)) {
                map[sum] = i
            }
        }

        return max
    }
}

fun main() {
    val solution = Solution()
    println(solution.findMaxLength(intArrayOf(0, 1)))
    println(solution.findMaxLength(intArrayOf(0, 1, 0)))
}