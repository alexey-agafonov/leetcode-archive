import java.util.*

class MinStack() {

    private val stack: Stack<Int> = Stack()
    private val minimum: Stack<Int> = Stack()

    fun push(value: Int) {
        stack.push(value)

        if (minimum.isEmpty() || value <= getMin()) {
            minimum.push(value)
        }
    }

    fun pop() {
        if (stack.isNotEmpty()) {
            val tmp = stack.pop()
            if (tmp == minimum.peek()) minimum.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minimum.peek()
    }
}

fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin())
    minStack.pop()
    println(minStack.top())
    println(minStack.getMin())
}