class Solution {
    fun largestNumber(nums: IntArray): String =
        nums.sortedWith (Comparator { o1, o2 ->
            var first = o1.toString()
            var second = o2.toString()

            val min = minOf(first.lastIndex, second.lastIndex)

            for (index in 0..min) {
                val firstIndex = first[index]
                val secondIndex = second[index]

                if (firstIndex > secondIndex) {
                    return@Comparator -1
                }

                if (firstIndex < secondIndex) {
                    return@Comparator 1
                }
            }

            if (first.lastIndex == second.lastIndex) return@Comparator -1

            var firstCheck = false

            if (min == first.lastIndex) {
                firstCheck = true
                second = second.substring(first.lastIndex + 1..second.lastIndex) + second.substring(0..first.lastIndex)

                repeat(second.lastIndex - first.lastIndex) {
                    first = first.plus(first.last())
                }
            } else {
                first = first.substring(second.lastIndex + 1..first.lastIndex) + first.substring(0..second.lastIndex)

                repeat(first.lastIndex - second.lastIndex) {
                    second = second.plus(second.last())
                }
            }

            return@Comparator if (first > second) -1 else if (first == second && firstCheck) -1 else 1
        }).joinToString(separator = "")
            .takeIf { !it.all { data -> data == '0' } }
            ?: "0"
}