class Solution {
    private val slash = "/"
    private val top = ".."
    private val current = "."

    fun simplifyPath(path: String): String {
        val deque = ArrayDeque<String>()

        for (command in path.split(slash)) {
            when {
                command == top && deque.isNotEmpty() -> deque.removeLast()
                command != top && command != current && command.isNotEmpty() -> deque.addLast(command)
            }
        }

        return slash + deque.joinToString(separator = slash)
    }
}