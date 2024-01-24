class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()

        val resultList: MutableList<List<Int>> = mutableListOf()

        val lastIndexOfNums = nums.lastIndex
        val target = target.toLong()

        repeat (lastIndexOfNums - 2) {
            if (it > 0 && nums[it - 1] == nums[it]) {
                return@repeat
            }

            for (j in it + 1 until lastIndexOfNums - 1) {
                var innerLeftPointer = j + 1
                var innerRightPointer = lastIndexOfNums

                if (j > it + 1 && nums[j] == nums[j - 1]) {
                    continue
                }

                val outerSum: Long = (nums[it] + nums[j]).toLong()

                while (innerLeftPointer < innerRightPointer) {
                    val currentSum: Long = nums[innerLeftPointer] + nums[innerRightPointer] + outerSum
                    
                    if (currentSum == target) {
                        resultList.add(
                            listOf(
                                nums[it], nums[j],
                                nums[innerLeftPointer], nums[innerRightPointer]
                            )
                        )

                        innerLeftPointer++
                        innerRightPointer--

                        while (innerLeftPointer < innerRightPointer && nums[innerLeftPointer] == nums[innerLeftPointer - 1]) {
                            innerLeftPointer++
                        }
                        while (innerLeftPointer < innerRightPointer && nums[innerRightPointer] == nums[innerRightPointer + 1]) {
                            innerRightPointer--
                        }
                    } else if (currentSum > target) {
                        innerRightPointer--
                    } else {
                        innerLeftPointer++
                    }
                }
            }
        }

        return resultList
    }
}