class Solution {
    fun sortColors(nums: IntArray): Unit {
        val red = mutableListOf<Int>()
        val white = mutableListOf<Int>()
        val blue = mutableListOf<Int>()

        nums.forEach {
            when (it) {
                0 -> red.add(it)
                1 -> white.add(it)
                2 -> blue.add(it)
                else -> throw IllegalArgumentException()
            }
        }

        (red + white + blue).forEachIndexed { index, data ->  
            nums[index] = data
        }
    }

}