class Solution {

    companion object {
        private val map = mapOf(
            1000 to "M",
            900 to "CM",
            500 to "D",
            400 to "CD",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            9 to "IX",
            5 to "V",
            4 to "IV",
            1 to "I"
        )
    }
    
    fun intToRoman(num: Int): String {
        var tempNum = num
        var answer = ""

        while (true) {
            for (key in map.keys) {
                if (tempNum == 0) {
                    return answer
                }

                if (tempNum >= key) {
                    tempNum -= key
                    answer += map[key]
                    break
                }
            }
        }
    }
    
}