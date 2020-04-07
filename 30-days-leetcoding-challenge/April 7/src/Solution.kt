class Solution {
    fun countElements(arr: IntArray): Int {
        if (arr.isEmpty() || arr.size > 1000) return 0

        var count = 0
        val tmp: HashSet<Int> = hashSetOf()

        arr.forEach { tmp.add(it) }

        for (i in arr.indices) {
            if ((arr[i] + 1) in tmp) count++
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.countElements(intArrayOf(1, 2, 3)))
    println(solution.countElements(intArrayOf(1, 1, 3, 3, 5, 5, 7, 7)))
    println(solution.countElements(intArrayOf(1, 3, 2, 3, 5, 0)))
    println(solution.countElements(intArrayOf(1, 1, 2, 2)))
}