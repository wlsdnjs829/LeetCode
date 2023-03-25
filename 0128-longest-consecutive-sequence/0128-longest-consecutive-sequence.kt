class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.size == 0) {
            return 0
        }
        nums.sort()
        var max = 1
        var longestFound = 1
        for (i in 1 until nums.size) {
            if (nums[i - 1] == nums[i] - 1) {
                longestFound++
            } else if (nums[i - 1] == nums[i]) {
                continue
            } else { 
                max = Math.max(max, longestFound)
                longestFound = 1
            }
        }
        return Math.max(max, longestFound)
    }
}