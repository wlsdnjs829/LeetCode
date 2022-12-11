class Solution {
    fun longestPalindrome(s: String): String {   
        val len = s.length
        val dp = Array(len) { BooleanArray(len) { false }}
        // base cases
        for (i in 0 until len - 1) {
            dp[i][i] = true            
            dp[i][i + 1] = (s[i] == s[i + 1])
        }
        dp[len - 1][len - 1] = true
        // ex. babad
        // <base cases>
        //   0 1 2 3 4
        // 0 T F 
        // 1   T F
        // 2     T F
        // 3       T F
        // 4         T
        
        // i = 2, compare second 'b' and 'd'
        // i = 1, compare first 'a' and second 'a'. then, first 'a' and 'd'
        // i = 0, compare first 'b' and second 'b'. then, ...    
        // j is always greater than i.
        // The order of i is decreasing because dp[i][j] depends on dp[i + 1][j - 1] which means i depends on i + 1.
        for (i in (len - 3) downTo(0)) {
            for (j in i + 2 until len) {
                dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
            }
        }
        // <result>
        //   0 1 2 3 4
        // 0 T F T F F
        // 1   T F T F
        // 2     T F F
        // 3       T F
        // 4         T
        
        var maxLen = 0
        var answer = ""
        for (i in 0 until len) {
            for (j in i until len) {
                if (dp[i][j] && maxLen < j - i+ 1) {
                    maxLen = j - i + 1
                    answer = s.substring(i, j + 1)
                }
            }
        }
        return answer
    }
}