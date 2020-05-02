class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        if (jewels.isEmpty() || jewels.isBlank() ||
            stones.isEmpty() || stones.isBlank()) return 0

        val chars = hashMapOf<Char,Int>()
        var count = 0
        stones.forEach { chars[it] = chars[it]?.plus(1) ?: 1 }
        jewels.forEach { count += chars[it] ?: 0 }

        return count
    }
}

fun main() {
    val solution = Solution()
    println(solution.numJewelsInStones("aA", "aAAbbbbb"))
    println(solution.numJewelsInStones("z", "ZZ"))
}
