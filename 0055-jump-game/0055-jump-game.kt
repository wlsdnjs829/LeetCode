class Solution {
    fun canJump(nums: IntArray): Boolean {
        var current = 0
        var index = 1

        val size = nums.size - 1

        repeat(size + 1) {
            when {
                it == 0 && nums[it] > 0 -> current = nums[it]
                current >= size -> return@canJump true
                index > current -> return@canJump false
                nums[index] == 0 -> index++
                index + nums[index] >= current -> {
                    current = nums[index] + index
                    index += 1
                }
                else -> index++
            }
        }

        return size == 0
    }
}