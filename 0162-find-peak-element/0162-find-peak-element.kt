class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var first = 0
        var last = nums.lastIndex

        while (first < last) {
            var middle = first + (last - first) / 2
            
            if (nums[middle] < nums[middle + 1]) {
                first = middle + 1
            } else {
                last = middle
            }
        }
        
        return first
    }
}