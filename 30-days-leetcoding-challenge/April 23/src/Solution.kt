class Solution {
    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        var x = m
        var y = n
        var shiftCnt = 0

        while (x != y) {
            x = x shr 1
            y = y shr 1
            shiftCnt++
        }

        return x shl shiftCnt
    }
}

fun main() {
    val solution = Solution()
    println(solution.rangeBitwiseAnd(5, 7))
    println(solution.rangeBitwiseAnd(0, 1))
    println(solution.rangeBitwiseAnd(1, 2))
    println(solution.rangeBitwiseAnd(2147483647, 2147483647))
}