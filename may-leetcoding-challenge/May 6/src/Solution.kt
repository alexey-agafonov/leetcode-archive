class Solution {
    fun majorityElement(nums: IntArray): Int {
        val countElement = HashMap<Int, Int>()

        nums.forEach { countElement[it] = countElement[it]?.plus(1) ?: 1 }
        return countElement.maxBy { it.value }?.key!!
    }
}

fun main() {
    val solution = Solution()
    println(solution.majorityElement(intArrayOf(3, 2, 3)))
    println(solution.majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}