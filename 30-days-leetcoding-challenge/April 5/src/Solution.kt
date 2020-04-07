class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0

        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1]
            }
        }

        return profit
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(solution.maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    println(solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}