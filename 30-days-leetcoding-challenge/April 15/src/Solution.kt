class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val left = IntArray(nums.size)
        val right = IntArray(nums.size)
        val result = IntArray(nums.size)

        left[0] = 1
        for (i in 1 until nums.size) {
            left[i] = left[i - 1] * nums[i - 1]
        }

        right[nums.size - 1] = 1
        for (i in nums.size - 2 downTo 0) {
            right[i] = right[i + 1] * nums[i + 1]
        }

        for (i in nums.indices) {
            result[i] = left[i] * right[i]
        }

        return result
    }
}

fun main() {
    val solution = Solution()
    val result = solution.productExceptSelf(intArrayOf(2, 3, 4, 5))
    result.forEach { println(it) }
}