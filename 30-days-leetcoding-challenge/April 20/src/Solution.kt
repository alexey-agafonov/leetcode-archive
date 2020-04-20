class Solution {
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        var result = TreeNode(preorder[0])

        if (preorder.size == 1)
            return result

        for (i in 1 until preorder.size) {
            insertElement(result, preorder[i])
        }

        return result
    }

    fun insertElement(node: TreeNode, value: Int) {
        if (node.value < value) {
            if (node.right == null) {
                node.right = TreeNode(value)
            } else {
                insertElement(node.right!!, value)
            }
        } else {
            if (node.left == null) {
                node.left = TreeNode(value)
            } else {
                insertElement(node.left!!, value)
            }
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.bstFromPreorder(intArrayOf(8, 5, 1, 7, 10, 12)))
}