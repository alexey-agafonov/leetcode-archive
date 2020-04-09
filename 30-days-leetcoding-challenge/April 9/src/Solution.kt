import java.util.*

class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        return removeBackspaces(s) == removeBackspaces(t)
    }

    private fun removeBackspaces(tmp: String): String {
        val stack: Stack<Char> = Stack()

        tmp.forEach {
            if (it == '#') {
                if (stack.isNotEmpty()) stack.pop()
            } else {
                stack.add(it)
            }
        }
        return stack.toString()
    }
}

fun main() {
    val solution = Solution()
    println(solution.backspaceCompare("ab#c", "ad#c"))
    println(solution.backspaceCompare("ab##", "c#d#"))
    println(solution.backspaceCompare("a##c", "#a#c"))
    println(solution.backspaceCompare("a#c", "b"))
}