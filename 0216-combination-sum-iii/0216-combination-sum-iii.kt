class Solution {
    private val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    private val numbersSize = numbers.size

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {

        val answer = mutableListOf<List<Int>>()

        answer.bt(
            combine = mutableListOf(),
            remain = n,
            startIndex = 0,
            allowElement = k
        )

        return answer
    }

    fun MutableList<List<Int>>.bt(
        combine: MutableList<Int>,
        remain: Int,
        startIndex: Int,
        allowElement: Int
    ) {
        if (remain == 0 && allowElement == combine.size) {
            this.add(combine.toList())
            return
        }
        
        if (allowElement <= combine.size) return

        for (index in startIndex until numbersSize) {
            val data = numbers[index]

            if (data > remain) break
            combine.add(data)

            this.bt(
                combine = combine,
                remain = remain - data,
                startIndex = index + 1,
                allowElement = allowElement
            )

            combine.removeAt(index = combine.lastIndex)
        }
    }
}