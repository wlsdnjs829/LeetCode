class Solution {
    fun trailingZeroes(n: Int): Int = if (n == 0) 0 else n / 5 + trailingZeroes(n / 5)
}