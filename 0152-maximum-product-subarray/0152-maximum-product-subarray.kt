class Solution {
    fun maxProduct(nums: IntArray): Int {
        var max = nums.max() ?: 0

        for (index in 0..nums.size - 2) {
            var temp = nums[index]

            for (nextIndex in index + 1 until nums.size) {
                temp *= nums[nextIndex]
                max = maxOf(max, temp)
            }
        }

        return max
    }
}