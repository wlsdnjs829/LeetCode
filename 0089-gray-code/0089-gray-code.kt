class Solution {
    fun grayCode(n: Int): List<Int> {
        return when (n) {
            0 -> listOf(0)
            else -> {
                val nextInt = n - 1
                val results = grayCode(nextInt)
                val preNum = 1 shl nextInt

                results + ((results.size - 1) downTo 0).map {
                    preNum + results[it]
                }
            }
        }
    }
}