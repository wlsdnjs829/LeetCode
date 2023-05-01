class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val originalArray = nums.copyOf()
        for (i in nums.indices) {
            val j = (i + k) % nums.size
            nums[j] = originalArray[i]
        }
    }
}