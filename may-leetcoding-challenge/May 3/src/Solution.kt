import kotlin.system.measureTimeMillis

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val chars =HashMap<Char, Int>()
        magazine.map { chars[it] = chars[it]?.plus(1) ?: 1 }

        ransomNote.forEach {
            if (it in chars && chars[it]!! > 0)
                chars[it] = chars[it]?.minus(1) ?: 0
            else return false
        }
        return true
    }
}

fun main() {
    val solution = Solution()
    println(solution.canConstruct("a", "b"))
    println(solution.canConstruct("aa", "ab"))
    println(solution.canConstruct("aab", "aab"))
}