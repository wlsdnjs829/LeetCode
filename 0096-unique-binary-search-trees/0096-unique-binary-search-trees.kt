class Solution {
    fun numTrees(n: Int): Int {
        return dp(n)
    }

    private fun dp(n: Int): Int {
        if (n <= 1) return 1

        var result = 0

        repeat(n) {
            val right = n - it - 1
            val left = it
            result += dp(left) * dp(right)
        }

        return result
    }
}