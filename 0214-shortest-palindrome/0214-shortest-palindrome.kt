class Solution {
    fun shortestPalindrome(s: String): String {
        val concat = "$s.${StringBuffer(s).reverse()}"

        val next = IntArray(concat.length)
        
        var i = 0
        var ptr = -1
        
        while (i < next.size) {
            while (ptr > -1 && concat[ptr + 1] != concat[i]) ptr = next[ptr]
            next[i] = if (i > 0 && concat[ptr + 1] == concat[i]) ptr + 1 else -1
            ptr = next[i]
            i++
        }
        
        return StringBuilder(s.subSequence(next[next.size - 1] + 1, s.length)).reverse().append(s).toString()
    }
}