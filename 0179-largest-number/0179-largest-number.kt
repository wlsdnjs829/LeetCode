class Solution {
    fun largestNumber(nums: IntArray): String =
        nums.map { it.toString() }
            .sortedWith(Comparator { a, b -> (b + a).compareTo(a + b)})
            .takeIf { it.first() != "0" }
            ?.joinToString(separator = "")
            ?: "0"
}