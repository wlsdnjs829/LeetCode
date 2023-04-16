class Solution {
    fun reverseWords(s: String): String =
        s.split(" ")
            .filter { it.isNotBlank() }
            .reversed()
            .joinToString(separator = " ")
}