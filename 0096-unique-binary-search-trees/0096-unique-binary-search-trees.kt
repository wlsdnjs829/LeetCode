class Solution {
    lateinit var dps: IntArray

    fun numTrees(n: Int): Int {
        dps = IntArray(n + 1) { -1 }
            .apply {
                this[0] = 1
                this[1] = 1
            }
        return dp(n)
    }

    private fun dp(n: Int): Int {
        if (dps[n] != -1) return dps[n]

        var result = 0

        repeat(n) {
            val right = n - it - 1
            val left = it
            result += dp(left) * dp(right)
        }

        dps[n] = result
        return result
    }
}