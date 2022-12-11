class Solution {

    fun generateParenthesis(n: Int): List<String> = generate(n).toList()

    private fun generate(n: Int): MutableSet<String> {
        if (n == 1) {
            return mutableSetOf(TEMPLATE)
        }

        val sets = generate(n - 1)
        val addedSets = mutableSetOf<String>()

        for (string in sets) {
            for (index in string.indices) {
                addedSets.add(
                    string.slice(0 .. index)
                            + TEMPLATE
                            + string.slice(index + 1 until string.length)
                )
            }
        }

        return addedSets
    }


    companion object {
        private const val TEMPLATE = "()"
    }
    
}