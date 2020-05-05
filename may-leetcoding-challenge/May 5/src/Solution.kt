class Solution {
    fun firstUniqChar(s: String): Int {
        val chars = HashMap<Char, Pair<Int, Int>>()
        s.forEachIndexed { idx, it ->
            val first = chars[it]?.first?.plus(1) ?: 1
            chars[it] = first to idx
        }
        val minIndex = chars.filterValues { it.first == 1 }.minBy { it.value.second }
        return minIndex?.value?.second ?: -1
    }
}

fun main() {
    val solution = Solution()
    println(solution.firstUniqChar("leetcode"))
    println(solution.firstUniqChar("loveleetcode"))
    println(solution.firstUniqChar("cc"))
}