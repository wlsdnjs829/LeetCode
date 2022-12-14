class Solution {
    
    fun longestPalindrome(s: String): String {
        val length = s.length

        for (index in length downTo 1) {
            val half = index / 2
            val even = index % 2 == 0

            for (num in s.indices) {
                if (num - half < 0 || ((num + half > length) || (num + half >= length && !even))) {
                    continue
                }

                if (even) {
                    val front = s.slice(num - half until num)
                    val back = s.slice(num until num + half)

                    if (front.reversed() == back) {
                        return front + back
                    }
                } else {
                    val front = s.slice(num - half until num)
                    val back = s.slice(num + 1 until num + half + 1)

                    if (front.reversed() == back) {
                        return front + s[num] + back
                    }
                }
            }
        }

        return s[0].toString()
    }

}