class Solution {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length-1
        while(i<j) {
            if(s[i] != s[j]) {
                return false
            } else {
                ++i
                --j
            }
        }
        return true
    }

    fun longestPalindrome(s: String): String {
        var longest = ""
        var len = s.length
        for(i in 0 .. len-1) {
            for(j in i .. len-1) {
                var oneSlice = s.slice(IntRange(i, j))
                if(longest.length <= oneSlice.length) {
                    if(isPalindrome(oneSlice)) {
                        longest = oneSlice
                    }
                }
            }
        }
        return longest
    }
}