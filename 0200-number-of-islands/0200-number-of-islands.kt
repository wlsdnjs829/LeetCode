class Solution {
    var count = 0

    fun numIslands(grid: Array<CharArray>): Int {
        for (i in grid.indices) {
            for (j in grid.first().indices) {
                if (grid[i][j] == '1') {
                    count++
                    grid.check(i = i, j = j)
                }
            }
        }

        return count
    }

    private fun Array<CharArray>.check(i: Int, j: Int) {
        if (i < 0 || i >= this.size || j < 0 || j >= this.first().size) return
        if (this[i][j] != '1') return

        this[i][j] = 'X'
        this.check(i = i + 1, j = j)
        this.check(i = i - 1, j = j)
        this.check(i = i, j = j + 1)
        this.check(i = i, j = j - 1)
    }
}