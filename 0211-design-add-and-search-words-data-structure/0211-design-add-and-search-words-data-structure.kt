class WordDictionary() {
    private val wordMap: MutableMap<Int, MutableList<String>> = mutableMapOf()

    fun addWord(word: String) {
        val length = word.length

        when(val words = wordMap[length]) {
            null -> wordMap[length] = mutableListOf(word)
            else -> words.add(word)
        }
    }

    fun search(word: String): Boolean {
        val words = wordMap[word.length]

        return when {
            words.isNullOrEmpty() -> false
            word.contains(DOT) -> {
                words.any {
                    for (index in it.indices) {
                        when (word[index]) {
                            DOT -> Unit
                            it[index] -> Unit
                            else -> return@any false
                        }
                    }

                    return@any true
                }
            }
            else -> words.contains(word)
        }
    }

    companion object {
        private const val DOT = '.'
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */