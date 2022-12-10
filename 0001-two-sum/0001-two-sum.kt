class Solution {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numsMap = nums.mapIndexed { index, num ->
            index to num
        }.groupByTo(
            HashMap(),
            { it.second },
            { it.first }
        )
        
        for ((index, num) in nums.withIndex()) {
            val indices = numsMap[target - num]
            val secondIndex = indices?.run {
                remove(index)
                firstOrNull()
            }
            
            if (secondIndex != null) {
                return intArrayOf(index, secondIndex)
            }
        }
        
        return intArrayOf()
    }

}