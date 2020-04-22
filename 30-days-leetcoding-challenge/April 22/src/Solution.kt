class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val savedSum: MutableMap<Int?, Int?> = HashMap()
        savedSum[0] = 1
        var sum = 0
        var result = 0

        for (num in nums) {
            sum += num
            result += savedSum.getOrDefault(sum - k, 0)!!
            savedSum.merge(sum, 1) { a: Int?, b: Int? -> Integer.sum(a!!, b!!) }
        }

        return result
    }
}

fun main() {
    val solution = Solution()
    println(solution.subarraySum(intArrayOf(1, 1, 1), 2))
}