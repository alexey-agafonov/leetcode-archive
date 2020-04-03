import kotlin.math.max

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var sum = nums[0]
        var result = nums[0]

        for (i in 1 until nums.size) {
            sum = max(nums[i], sum + nums[i])
            result = max(result, sum)
        }

        return result
    }
}