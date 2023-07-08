class Solution {
fun solveSudoku(board: Array<CharArray>): Unit {
        val rowRecord = Array(9) { mutableSetOf<Char>() }
        val columnRecord = Array(9) { mutableSetOf<Char>() }
        val subBoxRecord = Array(3) { Array(3) { mutableSetOf<Char>() } }

        fun fillCharAt(position: Pair<Int, Int>, char: Char): Boolean {
            if (rowRecord[position.first].contains(char)
                || columnRecord[position.second].contains(char)
                || subBoxRecord[position.first / 3][position.second / 3].contains(char)
            ) {
                return false
            }

            val currentChar = board[position.first][position.second]

            if (currentChar != '.') {
                rowRecord[position.first].remove(currentChar)
                columnRecord[position.second].remove(currentChar)
                subBoxRecord[position.first / 3][position.second / 3].remove(currentChar)
            }

            board[position.first][position.second] = char

            if (char != '.') {
                require(rowRecord[position.first].add(char))
                require(columnRecord[position.second].add(char))
                require(subBoxRecord[position.first / 3][position.second / 3].add(char))
            }

            return true
        }

        val positionsToFill: List<Pair<Int, Int>> = mutableListOf<Pair<Int, Int>>().also {
            board.forEachIndexed { rowIndex, chars ->
                chars.forEachIndexed { columnIndex, char ->
                    if (char == '.') {
                        it.add(rowIndex to columnIndex)
                    } else {
                        fillCharAt(rowIndex to columnIndex, char)
                    }
                }
            }
        }

        fun fill(positionIndex: Int): Boolean {
            if (positionIndex == positionsToFill.size) {
                return true
            }

            val position = positionsToFill[positionIndex]

            for (char in '1'..'9') {
                if (fillCharAt(position, char)) {
                    if (fill(positionIndex + 1)) {
                        return true
                    }
                    fillCharAt(position, '.')
                }
            }
            
            return false
        }
        
        fill(0)
    }
}