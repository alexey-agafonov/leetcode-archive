/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var i = 1
        var j = n

        while (i < j) {
            var mid = i + (j - i) / 2

            if (isBadVersion(mid))
                j = mid
            else
                i = mid + 1
        }

        return i
    }
}