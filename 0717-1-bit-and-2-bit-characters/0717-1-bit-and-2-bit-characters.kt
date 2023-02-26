class Solution {
    fun isOneBitCharacter(bits: IntArray): Boolean {
        val size = bits.size

        return when {
            size == 1 -> true
            bits[size - 2] == 0 -> true
            else -> {
                var data: Int? = 1
                
                (size - 3 downTo 0).forEach {
                    when (data) {
                        null -> data = bits[it]
                        0 -> return true
                        1 -> if (bits[it] == 0) return false else data = null  
                    }
                }
                
                return data == null || data == 0
            }
        }
    }
}