class Solution {
    
    companion object {
        private const val EMPTY = ""
    }

    fun convert(s: String, numRows: Int): String {
        var dir = 0
        var index = 0

        val map = mutableMapOf<Int, String>()

        s.forEach {
            if (index == 0) {
                dir = 1
            } else if (index == numRows - 1) {
                dir = -1
            }

            map[index] = map.getOrDefault(index, EMPTY) + it.toString()

            index += dir
        }

        return map.values.joinToString(EMPTY)
    }
    
}