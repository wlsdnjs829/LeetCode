class Solution {
    fun isMatch(s: String, p: String): Boolean {
        if (p.isEmpty()) {
            return s.isEmpty()
        }

        val isFirstMatch = s.isNotEmpty() && listOf(s.first(), '.').contains(p.first())

        return if (p.length >= 2 && p[1] == '*') {
            isMatch(s, p.substring(2, p.length)) ||
                    isFirstMatch && isMatch(s.substring(1, s.length), p)
        } else {
            isFirstMatch && isMatch(s.substring(1, s.length), p.substring(1, p.length))
        }
    }
}