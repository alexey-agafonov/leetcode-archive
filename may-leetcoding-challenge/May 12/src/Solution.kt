class Solution {
    fun singleNonDuplicate(nums: IntArray): Int {
        var unique = HashMap<Int, Int>()
        var i = 0
        var j = nums.size - 1

        while (i <= j) {
            unique[nums[i]] = unique[nums[i]]?.plus(1) ?: 1
            if (i < j)
                unique[nums[j]] = unique[nums[j]]?.plus(1) ?: 1

            i++
            j--
        }

        println(unique)

        return unique.filter { it.value == 1 }.keys.first()
    }
}

fun main() {
    val solution = Solution()
    println(solution.singleNonDuplicate(intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)))
    println(solution.singleNonDuplicate(intArrayOf(3, 3, 7, 7, 10, 11, 11)))
    println(solution.singleNonDuplicate(intArrayOf(1)))
}