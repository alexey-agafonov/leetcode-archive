class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        val nodes: MutableList<ListNode> = mutableListOf()
        var tmp = head

        while (tmp != null) {
            nodes.add(tmp)
            tmp = tmp.next
        }

        return nodes[nodes.size / 2]
    }
}

class AnotherSolution {
    fun middleNode(head: ListNode?): ListNode? {
        var node = head
        var middleNode = head

        while (node?.next != null) {
            middleNode = middleNode?.next
            node = node.next?.next
        }

        return middleNode
    }
}

fun main() {
    val solution = Solution()
    val anotherSolution = AnotherSolution()
    var head: ListNode? = null
    head = addNode(head, 1)
    head = addNode(head, 2)
    head = addNode(head, 3)
    head = addNode(head, 4)
    head = addNode(head, 5)

    println(solution.middleNode(head)?.value)
    println(anotherSolution.middleNode(head)?.value)

    head = null
    head = addNode(head, 1)
    head = addNode(head, 2)
    head = addNode(head, 3)
    head = addNode(head, 4)
    head = addNode(head, 5)
    head = addNode(head, 6)

    println(solution.middleNode(head)?.value)
    println(anotherSolution.middleNode(head)?.value)
}

fun addNode(node: ListNode?, value: Int): ListNode {
    if (node != null)
        node.next = addNode(node.next, value)
    else
        return ListNode(value)

    return node
}
