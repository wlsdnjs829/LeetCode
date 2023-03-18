/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?): Node? {
        bfs(root?.run { listOf(this) } ?: listOf())
        return root
    }

    private tailrec fun bfs(nodes: List<Node>) {
        if (nodes.isEmpty()) return

        val nextNodes = mutableListOf<Node>()

        for ((index, node) in nodes.withIndex()) {
            if (nodes.lastIndex != index) {
                node.next = nodes[index + 1]
            }

            node.left?.apply { nextNodes.add(this) }
            node.right?.apply { nextNodes.add(this) }
        }
        
        bfs(nextNodes)
    }
}