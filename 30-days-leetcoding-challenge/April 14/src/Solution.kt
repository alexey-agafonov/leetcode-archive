class Solution {
    fun stringShift(s: String, shift: Array<IntArray>): String {
        var shiftLength = 0
        for (i in shift.indices) {
            if (shift[i][0] == 1) shiftLength += shift[i][1] else shiftLength -= shift[i][1]
        }

        val length = s.length
        shiftLength %= s.length

        return if (shiftLength > 0) {
            s.substring(length - shiftLength) + s.substring(0, length - shiftLength)
        } else {
            s.substring(-shiftLength) + s.substring(0, -shiftLength)
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.stringShift("abc", arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))))

    println(solution.stringShift("abcdefg", arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(0, 2), intArrayOf(1, 3))))

    println(solution.stringShift("wpdhhcj", arrayOf(intArrayOf(0, 7),
            intArrayOf(1, 7), intArrayOf(1, 0), intArrayOf(1, 3), intArrayOf(0, 3),
            intArrayOf(0, 6), intArrayOf(1, 2))))
}