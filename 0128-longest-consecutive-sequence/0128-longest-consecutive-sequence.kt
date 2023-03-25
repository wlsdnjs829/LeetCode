class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numberSet: Set<Int> = nums.toSet()

        var maxConsequtive = 0
        numberSet.forEach { number ->
            if (numberSet.contains(number - 1).not()) {
                var currentNumber = number
                var currentConsequtive = 1
                while (numberSet.contains(currentNumber + 1)) {
                    currentNumber++
                    currentConsequtive++
                }

                maxConsequtive = Math.max(maxConsequtive, currentConsequtive)
            }
        }

        return maxConsequtive
    }
}