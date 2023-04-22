class MinStack() {

    private val stack = Stack<Int>()
    private var min = Int.MAX_VALUE
    private var count = 0

    fun push(`val`: Int) {
        stack.push(`val`)
        if (min == `val`) {
            count++
        } else {
            min = min.coerceAtMost(`val`)
            if (min == `val`) count = 1
        }
    }

    fun pop() {
        val pop = stack.pop()

        if (min == pop) {
            count--

            if (count == 0) {
                min = Int.MAX_VALUE
                
                for (data in stack) {
                    if (min == data) {
                        count++
                    } else {
                        min = min.coerceAtMost(data)
                        if (min == data) count = 1
                    }
                }
            }
        }
    }

    fun top(): Int = stack.peek()

    fun getMin(): Int = min
}