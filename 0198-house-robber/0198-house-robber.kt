class Solution {
    fun rob(nums: IntArray): Int =
        when (val size = nums.size) {
            1 -> nums[0]
            2 -> maxOf(nums[0], nums[1])
            else -> {
                val dp = IntArray(size)
                dp[0] = nums[0]
                dp[1] = maxOf(nums[0], nums[1])
                
                for (index in 2 until size) {
                    dp[index] = maxOf(dp[index - 2] + nums[index], dp[index - 1]) 
                }
                
                dp.last()
            }
        }
}