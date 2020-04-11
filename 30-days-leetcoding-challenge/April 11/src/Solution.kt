import kotlin.math.max

class Solution {
    var maxLength = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        maxDepth(root)
        return maxLength
    }

    private fun maxDepth(root: TreeNode?): Int {
        return if (root != null) {
            val leftDepth = maxDepth(root.left)
            val rightDepth = maxDepth(root.right)
            maxLength = max(maxLength, leftDepth + rightDepth)
            1 + max(leftDepth, rightDepth)
        } else 0
    }
}

fun main() {
    val solution = Solution()
    val root = TreeNode(1)
    val node1 = TreeNode(2)
    val node2 = TreeNode(3)
    val node3 = TreeNode(4)
    val node4 = TreeNode(5)
    root.left = node1
    root.right = node2
    node1.left = node3
    node1.right = node4
    println(solution.diameterOfBinaryTree(root))
}