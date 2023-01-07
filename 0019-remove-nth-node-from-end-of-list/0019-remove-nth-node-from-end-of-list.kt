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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? =
        mutableListOf<Int>().iterableNode(head)
            .convert(n)

    private tailrec fun MutableList<Int>.iterableNode(node: ListNode?): MutableList<Int> = if (node?.next == null) {
        node?.let {
            this.add(it.`val`)
        }
        this
    } else {
        this.add(node.`val`)
        this.iterableNode(node.next)
    }

    private fun MutableList<Int>.convert(n: Int): ListNode? {
        var tempNode: ListNode? = null
        this.removeAt(size - n)
        
        for (node in this.reversed()) {
            val listNode = ListNode(node)
            listNode.next = tempNode
            tempNode = listNode
        }

        return tempNode
    }
}