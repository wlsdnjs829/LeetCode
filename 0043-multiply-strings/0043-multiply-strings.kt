class Solution {
    fun multiply(num1: String, num2: String): String {
        val intArray = IntArray(num1.length + num2.length)

        for ((index1, cr1) in num1.withIndex()) {
            for ((index2, cr2) in num2.withIndex()) {
                intArray[index1 + index2 + 1] += Character.getNumericValue(cr1) * Character.getNumericValue(cr2)
            }
        }

        for (index in intArray.size - 2 downTo 0) {
            val nextVal = intArray[index + 1]
            if (nextVal >= 10) {
                intArray[index] += nextVal / 10
                intArray[index + 1] = nextVal % 10
            }
        }

        val answer = intArray.joinToString("")
        
        return if (answer.all { it == '0' }) {
            "0"
        } else if (answer.first() == '0') {
            answer.substringAfter("0")
        } else {
            answer
        }
    }
}