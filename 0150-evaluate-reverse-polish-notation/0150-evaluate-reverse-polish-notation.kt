class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()

        for (token in tokens) {
            val tokenToInt = token.toIntOrNull()
            if (tokenToInt == null) {
                val first = stack.pop()
                val second = stack.pop()

                stack.push(
                    when (token) {
                        "*" -> first * second
                        "/" -> second / first
                        "-" -> second - first 
                        else -> first + second
                    }
                )

                continue
            }

            stack.push(tokenToInt)
        }
        
        return stack.pop()
    }
}