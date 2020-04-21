class Solution {
    fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
        val n = binaryMatrix.dimensions()[0]
        val m = binaryMatrix.dimensions()[1]
        var i = 0
        var j = m - 1
        var index = -1

        if (n == 1 && m == 1 && binaryMatrix.get(n, m) == 1)
            return 0

        while (j >= 0 && i < n) {
            if (binaryMatrix.get(i, j) == 1) {
                index = j
                j--
                i = 0
            } else {
                i++
            }
        }

        return index
    }
}