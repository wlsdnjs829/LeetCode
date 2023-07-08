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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? = if (lists.isEmpty()) {
        null
    } else {
        lists.mergeKLists(start = 0, end = lists.size - 1)
    }


    private fun Array<ListNode?>.mergeKLists(start: Int, end: Int): ListNode? {
        if (start == end) {
            return this[start]
        }

        val mid = start + (end - start) / 2
        val left = this.mergeKLists(start = start, end = mid)
        val right = this.mergeKLists(start = mid + 1, end = end)
        return left merge right
    }

    private infix fun ListNode?.merge(right: ListNode?): ListNode? {
        var leftNode = this
        var rightNode = right

        val head = ListNode(-1)
        var temp: ListNode? = head

        while (leftNode != null && rightNode != null) {
            if (leftNode.`val` < rightNode.`val`) {
                temp!!.next = leftNode
                leftNode = leftNode.next
            } else {
                temp!!.next = rightNode
                rightNode = rightNode.next
            }

            temp = temp.next
        }

        while (leftNode != null) {
            temp!!.next = leftNode
            leftNode = leftNode.next
            temp = temp.next
        }

        while (rightNode != null) {
            temp!!.next = rightNode
            rightNode = rightNode.next
            temp = temp.next
        }

        return head.next
    }
}