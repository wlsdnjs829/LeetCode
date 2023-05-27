class Solution {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        val binaryLeft = left.toString(radix = 2)
        val binaryRight = right.toString(radix = 2)

        return when (binaryLeft.length) {
            binaryRight.length -> {
                var checkPoint = false

                binaryLeft.mapIndexed { index, binary ->
                    when {
                        checkPoint -> '0'
                        binary == binaryRight[index] -> binary
                        else -> {
                            checkPoint = true
                            '0'
                        }
                    }
                }.joinToString(separator = "")
                    .toInt(radix = 2)
            }

            else -> 0
        }
    }
}