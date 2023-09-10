class Solution {
  fun minDistance(word1: String, word2: String): Int {
    var dp = (0..word2.length).toList()
    
    for (ch1 in word1) {
      val prev = dp
      dp = mutableListOf()
      dp.add(prev[0] + 1)
      
      for ((idx, ch2) in word2.withIndex())
        dp.add(if (ch1 == ch2) prev[idx] else 1 + minOf(minOf(prev[idx], prev[idx + 1]), dp[idx]))
    }
    
    return dp.last()
  }
}