import kotlin.math.max

class Solution {
    fun checkValidString(string: String): Boolean {
        if (string == "()" || string == "*") {
            return true
        }

        var maxOpenLeft = 0
        var minOpenLeft = 0
        for (char in string) {
            if (char == '(') minOpenLeft++ else minOpenLeft--
            if (char != ')') maxOpenLeft++ else maxOpenLeft--
            if (maxOpenLeft < 0) return false
            minOpenLeft = max(0, minOpenLeft)
        }

        return minOpenLeft == 0
    }
}

fun main() {
    val solution = Solution()
    println(solution.checkValidString("()"))
    println(solution.checkValidString("(*)"))
    println(solution.checkValidString("(*))"))
    println(solution.checkValidString("())"))
}