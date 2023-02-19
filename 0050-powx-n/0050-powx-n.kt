class Solution {
fun myPow(x: Double, n: Int): Double {
        return when {
            x == 0.0 -> 0.0
            n == 0 -> 1.0
            n == 1 -> x
            n % 2 == 0 -> {
                val pow = myPow(x, n / 2)
                pow * pow
            }

            n % 2 == 1 -> {
                val pow = myPow(x, n / 2)
                x * pow * pow
            }

            else -> 1 / myPow(x, -n)
        }
    }
}