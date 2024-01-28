class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size

        for (i in 0 until n) {
            for (j in i until n) {
                val tmp = matrix[j][i]
                matrix[j][i] = matrix[i][j]
                matrix[i][j] = tmp
            }
        }

        matrix.forEach { row -> row.reverse() }
    }
}