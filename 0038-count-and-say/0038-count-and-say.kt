class Solution {
     fun countAndSay(n: Int): String {
        var answer = ""

        repeat(n) {
            answer = convert(answer)
        }

        return answer
    }

    private fun convert(digits: String): String {
        if (digits.isEmpty()) {
            return "1"
        }

        val answer = StringBuilder()

        var count = 0
        var target = 'a'

        for (digit in digits) {
            if (target != digit) {
                if (count != 0) {
                    answer.append(count.toString())
                    answer.append(target)
                }

                target = digit
                count = 0
            }

            count++
        }

        answer.append(count.toString())
        answer.append(target)        
        return answer.toString()
    }
}