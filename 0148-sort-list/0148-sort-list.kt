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
    fun sortList(head: ListNode?): ListNode? {
        if (head == null || head?.next == null) return head
        
        var slow = head; var fast = head
        var curr: ListNode? = null
        
        while (fast != null && fast?.next != null) {
            curr = slow
            slow = slow?.next
            fast = fast?.next?.next
        }
        
        curr?.next = null
        val left = sortList(head)
        val right = sortList(slow)
        
        return merge(left, right)
    }
    
    fun merge(left: ListNode?, right: ListNode?): ListNode? {
        if (left == null) return right
        if (right == null) return left
        
        return when {
            left.`val` < right.`val` -> {
                left?.next = merge(left.next, right)
                left
            }
            else -> {
                right?.next = merge(left, right.next)
                right
            }
        }
    }
}