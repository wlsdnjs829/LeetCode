class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val c = nums.distinct()
        for ((a, b) in c.withIndex()) { nums[a] = b }
        return c.size
    }
}