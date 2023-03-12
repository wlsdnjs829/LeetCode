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
    private val results = mutableListOf<List<Int>>()

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return listOf()
        nodeToList(listOf(root))
        return results
    }

    private tailrec fun nodeToList(nodes: List<TreeNode>) {
        if (nodes.isEmpty()) return
        
        val nextNodes = mutableListOf<TreeNode>()
        val result = mutableListOf<Int>()

        for (node in nodes) {
            result.add(node.`val`)
            node.left?.run { nextNodes.add(this) }
            node.right?.run { nextNodes.add(this) }
        }
        
        results.add(result)
        nodeToList(nextNodes)
    }
}