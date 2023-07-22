class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        var i = 0
        
        while (i < nums.size) {
            val index = nums[i] - 1
            if (index in nums.indices && nums[index] != nums[i])
                nums[i] = nums[index].also { nums[index] = nums[i] }
            else
                i++
        }
        
        for (i in nums.indices) {
            if (nums[i] != i + 1)
                return i + 1
        }
        
        return nums.size + 1
    }
}