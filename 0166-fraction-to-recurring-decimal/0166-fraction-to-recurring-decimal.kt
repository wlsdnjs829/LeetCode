import kotlin.math.abs

class Solution {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        if (numerator == 0) {
            return "0"
        }

        val res = StringBuilder()

        res.append(
            if ((numerator > 0) xor (denominator > 0)) "-" else ""
        )

        var num = abs(numerator.toLong())
        val den = abs(denominator.toLong())

        // integral part
        res.append(num / den)

        num %= den

        if (num == 0L) {
            return res.toString()
        }

        // fractional part
        res.append(".")

        val map = HashMap<Long, Int>()
        map[num] = res.length

        while (num != 0L) {
            num *= 10
            res.append(num / den)
            num %= den
            if (map.containsKey(num)) {
                val index = map[num]!!
                res.insert(index, "(")
                res.append(")")
                break
            } else {
                map[num] = res.length
            }
        }
        return res.toString()
    }
}