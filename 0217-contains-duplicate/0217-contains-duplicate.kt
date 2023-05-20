class Solution {
    fun containsDuplicate(nums: IntArray): Boolean = nums.size != nums.toSet().size

}