class Solution {
       fun strStr(haystack: String, needle: String): Int =
        haystack.split(needle)
            .takeIf { it.size > 1 }
            ?.run {
                this[0].length
            } ?: -1
}