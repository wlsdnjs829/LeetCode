class Solution {
    private var result: Int? = null
    private var current = 0
    var max = 0

    fun longestConsecutive(nums: IntArray): Int {
        val map = mutableMapOf<Int, Boolean>()

        nums.forEach { map[it] = true }

        map.keys.sorted()
            .forEach {
                when (result) {
                    null -> {
                        result = 1
                        current = it
                    }
                    else -> {
                        if (current + 1 == it) {
                            result = result?.inc()
                        } else {
                            max = maxOf(result!!, max)
                            result = 1
                        }

                        current = it
                    }
                }
            }

        return if ((result?.compareTo(max) ?: 0) > 0) {
            result!!
        } else max
    }

}