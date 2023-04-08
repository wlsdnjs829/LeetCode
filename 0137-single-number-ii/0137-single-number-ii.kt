class Solution {
    fun singleNumber(nums: IntArray): Int {
        val map = hashMapOf<Int, Int>()

        for (num in nums) {
            val data = map[num]

            when (map[num]) {
                null -> map[num] = 1
                1 -> map[num] = 2
                else -> map.remove(key = num)
            }
        }

        return map.keys.first()
    }
}