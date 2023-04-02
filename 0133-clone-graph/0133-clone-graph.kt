/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    
    private val nodeMap = hashMapOf<Int, Node>()

    fun cloneGraph(node: Node?): Node? {
        return if (node == null) null else finderNode(node)
    }

    private fun finderNode(node: Node): Node {
        if (nodeMap[node.`val`] != null) return nodeMap[node.`val`]!!

        val newNode = Node(`val` = node.`val`)
        nodeMap[node.`val`] = newNode

            for (neighbors in node.neighbors) {
            if (neighbors == null) continue
            newNode.neighbors.add(finderNode(neighbors))
        }

        return newNode
    }

    
}