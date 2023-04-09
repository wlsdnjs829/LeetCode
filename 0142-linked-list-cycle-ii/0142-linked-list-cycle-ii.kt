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
    fun detectCycle(head: ListNode?): ListNode? {
        if (head?.next == null || head.next?.next == null) return null

        var slow = head.next
        var fast = head.next?.next

        while (slow != fast) {
            slow = slow?.next
            fast = fast?.next?.next

            if (slow == fast) {
                slow = head

                while (slow != fast) {
                    slow = slow?.next
                    fast = fast?.next
                }

                return slow
            }
        }

        return slow
    }
}