class Solution {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val point1 = coordinates[1]
        val point2 = coordinates[0]
        val gSlope = slope(point1, point2)
        for (i in 1 until coordinates.size) {
            val p1 = coordinates[i]
            val p2 = coordinates[0]
            val slop = slope(p1, p2)
            if (gSlope != slop) return false
        }
        return true
    }

    private fun slope(p1: IntArray, p2: IntArray): Float {
        return if (p1[0] - p2[0] == 0) 0.toFloat() else (p2[1] - p1[1]).toFloat() / (p2[0] - p1[0])
    }
}

fun main() {
    val solution = Solution()
    println(solution.checkStraightLine(arrayOf(intArrayOf(1, 2),
                                               intArrayOf(2, 3),
                                               intArrayOf(3, 4),
                                               intArrayOf(4, 5),
                                               intArrayOf(5, 6),
                                               intArrayOf(6, 7))))

    println(solution.checkStraightLine(arrayOf(intArrayOf(1, 1),
                                               intArrayOf(2, 2),
                                               intArrayOf(3, 4),
                                               intArrayOf(4, 5),
                                               intArrayOf(5, 6),
                                               intArrayOf(7, 7))))
}