class Trie {
    private val root = TrieNode(key = null, parent = null)

    fun insert(word: String) {
        var current = root

        word.forEach { element ->
            if (current.children[element] == null) {
                current.children[element] = TrieNode(element, current)
            }

            current = current.children[element]!!
        }

        current.isTerminating = true
    }

    fun search(word: String): Boolean {
        var current = root

        word.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }

        return current.isTerminating
    }

    fun startsWith(prefix: String): Boolean {
        var current = root

        prefix.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }

        return true
    }
}

class TrieNode(var key: Char?, var parent: TrieNode?) {
    val children: HashMap<Char, TrieNode> = HashMap()
    var isTerminating = false
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */