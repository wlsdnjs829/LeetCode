import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        val index = height.size - 1

        var left = 0
        var right = index
        var max = 0

        repeat(index) {
            max = maxOf(min(height[left], height[right]) * (right - left), max)

            if (height[left] > height[right]) {
                right--
            } else {
                left++
            }
        }

        return max
    }
}