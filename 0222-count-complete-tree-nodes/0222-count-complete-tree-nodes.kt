/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun countNodes(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val left = countNodes(root = root.left)
        val right = countNodes(root = root.right)

        return left + right + 1
    }
}