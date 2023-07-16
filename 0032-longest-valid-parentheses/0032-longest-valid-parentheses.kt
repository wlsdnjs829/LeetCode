import kotlin.math.max

class Solution {
    fun longestValidParentheses(S: String): Int {
        val deque: ArrayDeque<Int> = ArrayDeque()
        deque.addLast(-1)
        var ans = 0

        for (i in S.indices) {
            if (S[i] == '(') {
                deque.addLast(i)
            } else {
                deque.removeLast()
                
                if (deque.isEmpty()) {
                    deque.addLast(i)
                } else {
                    ans = max(ans, i - deque.last())
                }
            }
        }

        return ans
    }
}