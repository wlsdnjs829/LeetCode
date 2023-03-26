class Solution {
    
    fun solve(board: Array<CharArray>): Unit {
        iterator(board) { row, column ->
            if (row == 0 || row == board.lastIndex || column == 0 || column == board.first().lastIndex) {
                dfs(board, row, column)
            }
        }

        iterator(board) { row, column ->
            board[row][column] = when (board[row][column]) {
                'F' -> 'O'
                else -> 'X'
            } 
        }
    }

    private fun iterator(board: Array<CharArray>, method: (Int, Int) -> Unit) {
        for (row in board.indices) {
            for (column in board.first().indices) {
                method(row, column)
            }
        }
    }

    fun dfs(board: Array<CharArray>, row: Int, column: Int) {
        if (row !in board.indices || column !in board.first().indices || board[row][column] != 'O') return
        
        board[row][column] = 'F'
        dfs(board, row + 1, column)
        dfs(board, row - 1, column)
        dfs(board, row, column + 1)
        dfs(board, row, column - 1)
    }

}