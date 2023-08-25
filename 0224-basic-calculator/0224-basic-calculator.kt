class Solution {
	class Item(val index: Int, val res: Int)

	fun calculate(s: String): Int {
		return calculate(s, 0).res
	}

	fun calculate(s: String, start: Int): Item {
		var res = 0
		var num = 0
		var operate = '+'
		var i = start
		while (true) {
			if (i < s.length && s[i] == ' ') {
				i ++
				continue
			}
			if (i >= s.length || s[i] == ')') {
				res += calculate(operate, num)
				return Item(i, res)
			} else if (s[i] == '+' || s[i] == '-') {
				if (num != 0) {
					res += calculate(operate, num)
					num = 0
				}
				operate = s[i]
			} else if (s[i] in '0'..'9') {
				num = num * 10 + s[i].toInt() - '0'.toInt()
			} else if (s[i] == '(') {
				val item = calculate(s, i + 1)
				res += calculate(operate, item.res)
				i = item.index
			}
			i ++
		}
	}

	fun calculate(operate: Char, num: Int) : Int {
		return if (operate == '-') {
			-num
		} else {
			num
		}
	}
}