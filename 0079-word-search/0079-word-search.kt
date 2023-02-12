class Solution {
    var horizon = 0
    var vertical = 0
    private lateinit var checkBoard: Array<BooleanArray>

    fun exist(board: Array<CharArray>, word: String): Boolean {
        horizon = board.size
        vertical = board[0].size
        checkBoard = Array(horizon) { BooleanArray(vertical) { false } }

        for (verticalIndex in 0 until vertical) {
            for (horizonIndex in 0 until horizon) {
                if (board[horizonIndex][verticalIndex] == word[0]) {
                    checkBoard[horizonIndex][verticalIndex] = true

                    if (check(board, word, horizonIndex, verticalIndex)) {
                        return true
                    }

                    checkBoard[horizonIndex][verticalIndex] = false
                }
            }
        }

        return false
    }

    private fun check(board: Array<CharArray>, word: String, x: Int, y: Int): Boolean {
        if (word.length == 1) {
            return true
        }

        val newWord = word.removeRange(0, 1)
        val targetChar = newWord[0]

        if (x > 0 && !checkBoard[x - 1][y] && board[x - 1][y] == targetChar) {
            checkBoard[x - 1][y] = true

            if (check(board, newWord, x - 1, y)) {
                return true
            }

            checkBoard[x - 1][y] = false
        }

        if (x < horizon - 1 && !checkBoard[x + 1][y] && board[x + 1][y] == targetChar) {
            checkBoard[x + 1][y] = true

            if (check(board, newWord, x + 1, y)) {
                return true
            }

            checkBoard[x + 1][y] = false
        }

        if (y > 0 && !checkBoard[x][y - 1] && board[x][y - 1] == targetChar) {
            checkBoard[x][y - 1] = true

            if (check(board, newWord, x, y - 1)) {
                return true
            }

            checkBoard[x][y - 1] = false
        }

        if (y < vertical - 1 && !checkBoard[x][y + 1] && board[x][y + 1] == targetChar) {
            checkBoard[x][y + 1] = true

            if (check(board, newWord, x, y + 1)) {
                return true
            }

            checkBoard[x][y + 1] = false
        }

        return false
    }
}