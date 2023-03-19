class Solution {
    private lateinit var dp: Array<IntArray>

    fun minimumTotal(triangle: List<List<Int>>): Int {
        dp = Array(size = triangle.size) { IntArray(size = triangle.last().size) { -1 } }
        return finder(triangle = triangle, row = 0, col = 0)
    }

    private fun finder(triangle: List<List<Int>>, row: Int, col: Int): Int {
        if (row + 1 >= dp.size) return triangle[row][col]

        val pathLeft = if (dp[row + 1][col] == -1) {
            dp[row + 1][col] = finder(triangle = triangle, row = row + 1, col = col)
            dp[row + 1][col]
        } else {
            dp[row + 1][col]
        }

        val pathRight = if (dp[row + 1][col + 1] == -1) {
            dp[row + 1][col + 1] = finder(triangle = triangle, row = row + 1, col = col + 1)
            dp[row + 1][col + 1]
        } else {
            dp[row + 1][col + 1]
        }

        return triangle[row][col] + minOf(pathLeft, pathRight)
    }
}