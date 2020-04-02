class Solution {
    fun singleNumber(nums: IntArray): Int {
        return nums.reduce { x, y -> x xor y }
    }
}