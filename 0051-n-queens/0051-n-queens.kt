import kotlin.math.abs

class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val positions = IntArray(n) { -1 }
        var result = mutableListOf<List<String>>()

        solveNQueens(positions, 0, n, result)

        return result
    }

    private fun solveNQueens(positions: IntArray, depth: Int, n: Int, result: MutableList<List<String>>) {
        if (depth == n) {
            result += (0 until n).map { String(CharArray(n) { index -> if (index == positions[it]) 'Q' else '.' }) }
            return
        }

        for (i in 0 until n) {
            if ((0 until depth).any { i == positions[it] || abs(depth - it) == abs(i - positions[it]) }) continue

            positions[depth] = i
            solveNQueens(positions, depth + 1, n, result)
        }
    }
}