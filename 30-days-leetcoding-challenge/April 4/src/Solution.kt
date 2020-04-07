class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var i = 0
        var current = 0

        while (i < nums.size.dec()) {
            if (nums[i] == 0 && nums[i + 1] != 0) {
                nums[current] = nums[i + 1]
                nums[i + 1] = 0
                current++
            } else if (nums[i] != 0) {
                current++
            }
            i++
        }

        nums.forEach { print("$it ") }
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.moveZeroes(intArrayOf(0, 1, 0, 0, 0, 3, 12))
}