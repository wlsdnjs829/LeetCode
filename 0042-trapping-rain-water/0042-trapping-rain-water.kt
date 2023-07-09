class Solution {
    fun trap(height: IntArray): Int {
        val len = height.size
        
        if (len == 0) {
            return 0
        }
        
        val left = IntArray(size = len)
        var max = height.first()

        (0 until len).forEach {
            max = maxOf(a = max, b = height[it])
            left[it] = max 
        }

        val right = IntArray(size = len)
        max = height.last()

        (len - 1 downTo 0).forEach {
            max = maxOf(a = max, b = height[it])
            right[it] = max
        }

        return (0 until len).sumBy {
            minOf(a = left[it], b = right[it]) - height[it]
        }
    }

}