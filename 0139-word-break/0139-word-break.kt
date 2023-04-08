class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length + 1) { it == 0 }
        val map = wordDict.associateWith { true }

        for (index in dp.indices) {
            for (next in 0..index) {
                if (dp[next] && map[s.substring(next until index)] == true) {
                    dp[index] = true
                }
            }
        }

        return dp[dp.lastIndex]
    }
}