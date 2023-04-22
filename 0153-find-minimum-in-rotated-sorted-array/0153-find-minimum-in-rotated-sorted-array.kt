class Solution {
    fun findMin(nums: IntArray): Int {
        if (nums.size < 3) return nums.min()!!

        var first = 0
        var last = nums.lastIndex
        var middle = nums.lastIndex / 2
        var min = nums.first()

        while (true) {
            val temp = nums[middle]
            min = min.coerceAtMost(temp)

            if (first == middle || last == middle) break

            val left = nums[first]
            val right = nums[last]

            if ((temp > right && left > right) || right > left) {
                first = middle
                middle = (if ((middle + last) % 2 == 0) middle + last else middle + last + 1) / 2
                continue
            }

            last = middle
            middle = (if ((middle + first) % 2 == 0) middle + first else middle + first + 1) / 2
        }

        return min
    }
}