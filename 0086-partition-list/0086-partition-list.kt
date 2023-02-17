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
    private var firstNode: ListNode? = null
    var beforeNode: ListNode? = null

    var secondNode: ListNode? = null
    var afterNode: ListNode? = null
    
    fun partition(head: ListNode?, x: Int): ListNode? {
        var node = head
        
        while (node != null) {
            node = node.get(x)
        }
        
        beforeNode?.next = secondNode
        return firstNode ?: secondNode
    }
    
    fun ListNode.get(x: Int) : ListNode? {
        when {
            this.`val` >= x -> {
                if (secondNode == null) {
                    secondNode = this
                    afterNode = this
                } else {
                    afterNode?.next = this
                    afterNode = this
                }
            }
            else -> {
                if (firstNode == null) {
                    firstNode = this
                    beforeNode = this
                } else {
                    beforeNode?.next = this
                    beforeNode = this
                }
            }
        }
        
        val nextNode = this.next
        this.next = null
        return nextNode
    }
}