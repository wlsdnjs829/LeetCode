class Solution {
    fun minWindow(s: String, t: String): String {
        val count = IntArray(128)
        var required = t.length
        var bestLeft = -1
        var minLength = s.length + 1
        for (c in t.toCharArray()) ++count[c.toInt()]
        var l = 0
        var r = 0
        while (r < s.length) {
            if (--count[s[r].toInt()] >= 0) --required
            while (required == 0) {
                if (r - l + 1 < minLength) {
                    bestLeft = l
                    minLength = r - l + 1
                }
                if (++count[s[l++].toInt()] > 0) ++required
            }
            ++r
        }
        return if (bestLeft == -1) "" else s.substring(bestLeft, bestLeft + minLength)
    }
}