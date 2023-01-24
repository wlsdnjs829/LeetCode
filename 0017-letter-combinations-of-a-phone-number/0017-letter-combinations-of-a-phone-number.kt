class Solution {
        fun letterCombinations(digits: String): List<String> {
        val mapOf = mapOf(
            '2' to listOf("a", "b", "c"),
            '3' to listOf("d", "e", "f"),
            '4' to listOf("g", "h", "i"),
            '5' to listOf("j", "k", "l"),
            '6' to listOf("m", "n", "o"),
            '7' to listOf("p", "q", "r", "s"),
            '8' to listOf("t", "u", "v"),
            '9' to listOf("w", "x", "y", "z")
        )

        val digitMap = digits.map {
            mapOf[it]!!
        }
        
        if (digitMap.isEmpty()) {
            return emptyList()
        }

        return digitMap[0].combine(1, digitMap)
    }

    private tailrec fun List<String>.combine(index: Int, digitMap: List<List<String>>): List<String> =
        if (index == digitMap.size) {
            this
        } else {
            val nextLetters = digitMap[index].flatMap {
                this.map { letter ->
                    letter + it
                }
            }

            nextLetters.combine(index + 1, digitMap)
        }
}