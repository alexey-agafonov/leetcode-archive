class Solution {
    fun getSum(n: Int): Int {
        var number = n
        var pow = 0

        while(number > 0){
            val digit = number % 10
            pow += digit * digit
            number /= 10
        }
        return pow
    }

    fun isHappy(n: Int): Boolean {
        val seen = hashSetOf<Int>()
        var current = n

        while (true) {
            if (seen.contains(current)) return false
            else if (current == 1) return true
            seen.add(current)
            current = getSum(current)
        }
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.isHappy(19))
}