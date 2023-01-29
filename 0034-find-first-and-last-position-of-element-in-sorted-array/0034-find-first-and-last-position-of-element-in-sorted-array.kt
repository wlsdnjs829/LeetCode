class Solution {
 fun searchRange(nums: IntArray, target: Int): IntArray {
        val start = 0
        val end = nums.size
        var last = end
        var middle = end / 2

        if (end == 0) {
            return intArrayOf(-1, -1)
        }

        repeat(end) {
            val data = nums[middle]
            when {
                data < target -> middle = (last + middle) / 2
                data > target -> {
                    last = middle
                    middle /= 2
                }
                data == target -> {
                    var first = middle
                    var last = middle

                    for (index in middle - 1 downTo start) {
                        if (nums[index] != target) {
                            break
                        }

                        first = index
                    }

                    for (index in middle + 1 until  end) {
                        if (nums[index] != target) {
                            break
                        }

                        last = index
                    }

                    return intArrayOf(first, last)
                }
            }

            if (middle < start || middle > end - 1) {
                return intArrayOf(-1, -1)
            }
        }

        return intArrayOf(-1, -1)
    }
}