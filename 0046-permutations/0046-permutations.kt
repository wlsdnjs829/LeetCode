class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        cur(mutableListOf(), answer, nums)
        return answer
    }

    private fun cur(indices: MutableList<Int>, answer: MutableList<List<Int>>, nums: IntArray) {
        for (index in nums.indices) {
            if (indices.contains(index)) {
                if (index == nums.size - 1) {
                    indices.removeAt(indices.lastIndex)
                }

                continue
            }

            indices.add(index)

            if (nums.size == indices.size) {
                val elements = mutableListOf<Int>()

                for (answerIndex in indices) {
                    elements.add(nums[answerIndex])
                }

                answer.add(elements)
                indices.removeAt(indices.lastIndex)

                if (indices.isNotEmpty() && index == nums.size - 1) {
                    indices.removeAt(indices.lastIndex)
                }

                continue
            }

            cur(indices, answer, nums)

            if (indices.isNotEmpty() && index == nums.size - 1) {
                indices.removeAt(indices.lastIndex)
            }
        }
    }
}