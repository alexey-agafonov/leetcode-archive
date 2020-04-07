class Solution {
    fun singleNumber(nums: IntArray): Int {
        return nums.reduce { x, y -> x xor y }
    }
}
fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.singleNumber(intArrayOf(2, 2, 1)))
    println(solution.singleNumber(intArrayOf(4, 1, 2, 1, 2)))
}