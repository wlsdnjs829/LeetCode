class Solution {
    fun isMatch(s: String, p: String): Boolean {
        if (s == null || p == null) return false
        val lenS = s.length
        val lenP = p.length

        var dp = Array(lenS+1) {BooleanArray(lenP+1) {false}}
        dp[0][0] = true
        for (i in 0 until lenP) {
            if(p[i] == '*' && dp[0][i - 1]) {
                dp[0][i+1] = true
            }
        }

        for(i in 0 until lenS) {
            for (j in 0 until lenP) {
                if (p[j] == '.' || p[j] == s[i]) {
                    dp[i+1][j+1] = dp[i][j]
                } else if(p[j] == '*') {
                    if (p[j - 1] != s[i] && p[j-1] != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1]
                    } else {
                        dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]
                    }
                }                
            }
        }
        return dp[lenS][lenP]
    }
}