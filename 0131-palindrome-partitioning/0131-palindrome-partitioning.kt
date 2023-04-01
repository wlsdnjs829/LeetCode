class Solution {
    fun partition(s: String): List<List<String>> {
        if (s.isEmpty()) return listOf(listOf())

        return finder(s = s, creator = mutableListOf())
    }

    private fun finder(s: String, creator: MutableList<String>): MutableList<List<String>> {
        val answer = mutableListOf<List<String>>()

        val first = s.first()
        val copyList = creator.toMutableList()
        copyList.add(first.toString())

        if (s.length < 2) {
            return mutableListOf(copyList)
        }

        answer.addAll(finder(s = s.substring(1 until s.length), creator = copyList))

        for (index in s.length downTo 1) {
            if (index == 1) return answer

            val palindromeSubString = s.substring(0 until index)

            if (palindrome(s = palindromeSubString)) {
                val palindromeCopyList = creator.toMutableList()
                palindromeCopyList.add(palindromeSubString)

                if (index == s.length) {
                    answer.add(palindromeCopyList)
                } else {
                    answer.addAll(finder(s = s.substring(index until s.length), creator = palindromeCopyList))
                }
            }
        }
        
        return answer
    }

    private fun palindrome(s: String): Boolean {
        val count = if (s.length % 2 == 0) {
            s.length / 2
        } else (s.length / 2) + 1

        for (index in 0 until count) {
            if (s[0 + index] != s[s.length - 1 - index]) {
                return false
            }
        }

        return true
    }
}