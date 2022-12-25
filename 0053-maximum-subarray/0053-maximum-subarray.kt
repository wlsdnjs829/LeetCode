
class Solution {
    // 카데인 알고리즘
    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]
        var tempMax = max

        for (index in (1 until nums.size)) {
            tempMax = maxOf(tempMax + nums[index], nums[index])
            max = maxOf(tempMax, max)
        }

        return max
    }
}