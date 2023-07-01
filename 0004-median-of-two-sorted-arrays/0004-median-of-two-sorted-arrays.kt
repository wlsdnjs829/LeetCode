class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val mergedNums = mutableListOf<Int>()

        val firstArrayDeque = nums1.toCollection(destination = ArrayDeque())
        val secondArrayDeque = nums2.toCollection(destination = ArrayDeque())

        while (firstArrayDeque.isNotEmpty() && secondArrayDeque.isNotEmpty()) {
            if (firstArrayDeque.first() < secondArrayDeque.first()) {
                mergedNums.add(element = firstArrayDeque.removeFirst())
            } else {
                mergedNums.add(element = secondArrayDeque.removeFirst())
            }
        }

        if (firstArrayDeque.isNotEmpty()) {
            mergedNums.addAll(elements = firstArrayDeque)
        } else {
            mergedNums.addAll(elements = secondArrayDeque)
        }

        return if (mergedNums.size <= 2) {
            mergedNums.average()
        } else {
            if (mergedNums.size % 2 == 0) {
                val medianIdx = mergedNums.size / 2
                (mergedNums[medianIdx - 1] + mergedNums[medianIdx]) / 2.0
            } else {
                mergedNums[mergedNums.size / 2].toDouble()
            }
        }
    }

}