class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length + 1) { it == 0 }

        for (index in dp.indices) {
            for (next in 0..index) {
                if (dp[next] && wordDict.contains(s.substring(next until index))) {
                    dp[index] = true
                    break
                }
            }
        }

        return dp[dp.lastIndex]
    }
}