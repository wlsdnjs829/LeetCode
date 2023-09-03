class Solution {
    fun singleNumber(nums: IntArray): IntArray = nums.fold(mutableMapOf<Int, Int>()) { map, i ->
            map.apply {
                map[i] = map.getOrDefault(i, 0).plus(1) }
        }.filterNot { (_, v) -> v == 2 }.keys.toIntArray()
}