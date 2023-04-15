/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reorderList(head: ListNode?): Unit {
        val map = mutableMapOf<Int, ListNode>()
        var node: ListNode? = head
        var index = 0

        while (node != null) {
            map[index] = node
            index++
            node = node.next
        }

        val size = if (map.size % 2 == 0) (map.size / 2) - 1 else map.size / 2
        val lastIndex = map.size - 1

        for (i in 0..size) {
            val firstNode = map[0 + i]

            if (0 + i != 0) {
                map[lastIndex - i + 1]?.next = firstNode
            }

            val lastNode = map[lastIndex - i]

            firstNode?.next = lastNode
            
            if (i == size) lastNode?.next = null
        }
    }
}