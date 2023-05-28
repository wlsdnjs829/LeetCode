class Solution {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        var len = Int.MAX_VALUE
        var sum = 0
        var left = 0
        
        for (i in nums.indices) {
            sum += nums[i]
            
            while (sum >= s) {
                len = len.coerceAtMost(i + 1 - left)
                sum -= nums[left]
                left++
            }
        }
        
        return if (len == Int.MAX_VALUE) 0 else len
    }
}