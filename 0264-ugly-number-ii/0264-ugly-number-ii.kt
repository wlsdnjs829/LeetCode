import kotlin.math.min

class Solution {
    fun nthUglyNumber(n: Int): Int {
        val intArray = IntArray(n)
        intArray[0] = 1

        var two = 0
        var three = 0
        var five = 0

        for (index in 1 until n) {
            val calTwo = intArray[two] * 2
            val calThree = intArray[three] * 3
            val calFive = intArray[five] * 5

            val element = min(min(calTwo, calThree), calFive)

            if (calTwo == element) two++
            if (calThree == element) three++
            if (calFive == element) five++

            intArray[index] = element
        }

        return intArray[n - 1]
    }
}