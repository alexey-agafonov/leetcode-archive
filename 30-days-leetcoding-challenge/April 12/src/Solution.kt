import java.util.*
import kotlin.math.max
import kotlin.math.min

class Solution {

    fun lastStoneWeight(stones: IntArray): Int {
        var stones = stones.toMutableList()

        while (stones.size > 1) {
            stones.sort()
            val y = stones[stones.lastIndex]
            val x = stones[stones.lastIndex - 1]
            if (x == y) {
                stones.removeAt(stones.lastIndex)
                stones.removeAt(stones.lastIndex)
            } else {
                stones[stones.lastIndex] = y - x
                stones.removeAt(stones.lastIndex - 1)
            }
        }

        return if (stones.isNotEmpty()) stones.first() else 0
    }
}

class AnotherSolution {

    fun lastStoneWeight(stones: IntArray): Int {
        val queue = PriorityQueue<Int>() { x, y -> y - x }
        stones.forEach { it -> queue.offer(it) }

        while (queue.isNotEmpty()) {
            val y = queue.poll()
            if (queue.isEmpty()) return y
            val x = queue.poll()
            if (x == y) continue
            queue.offer(max(x, y) - min(x, y))
        }

        return 0
    }
}

fun main() {
    val solution = Solution()
    println(solution.lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
    
    val anotherSolution = AnotherSolution()
    println(anotherSolution.lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
}