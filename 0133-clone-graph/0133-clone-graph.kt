/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    
    val visited = mutableMapOf<Node, Node>()

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        if (visited.get(node) != null) return visited[node]

        val clone = Node(node.`val`)
         visited[node] = clone
        for (neighbor in node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor))
        }

        return clone
    }

}