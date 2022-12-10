class Solution {
    
    fun threeSum(nums: IntArray): List<List<Int>> {
        val answer = mutableSetOf<List<Int>>()

        val numsMap = mutableMapOf<Int, Int>()

        for (num in nums) {
            if (numsMap.computeIfPresent(num) { _, v -> v + 1 } == null) {
                numsMap[num] = 1
            }
        }

        val keys = numsMap.keys.toList()
        val size = keys.size - 2

        for (index in 0..size) {
            for (secondIndex in index + 1..size) {
                val first = keys[index]
                val second = keys[secondIndex]

                val value = 0 - (first + second)

                if (first != value && second != value && numsMap[value] != null) {
                    answer.add(listOf(first, second, value).sorted())
                }
            }
        }

        val twoKeys = numsMap.filterValues { it >= 2 }
            .keys

        for (num in twoKeys) {
            val value = 0 - (num + num)

            if (num != value && numsMap[value] != null) {
                answer.add(listOf(num, num, value))
            }
        }

        val threeKeys = numsMap.filterValues { it >= 3 }
            .keys

        for (num in threeKeys) {
            if (num + num + num == 0) {
                answer.add(listOf(num, num, num))
            }
        }

        return answer.toList()
    }

}