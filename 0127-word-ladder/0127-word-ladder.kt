class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val set: Set<String> = HashSet(wordList)
        if (!set.contains(endWord)) return 0
        
        val queue: Queue<String> = LinkedList()
        queue.add(beginWord)
        
        val visited: MutableSet<String> = HashSet()
        queue.add(beginWord)
        
        var changes = 1
        
        while (!queue.isEmpty()) {
            val size: Int = queue.size
            
            for (i in 0 until size) {
                val word: String = queue.poll()
                if (word == endWord) return changes
                
                for (j in word.indices) {
                    var k = 'a'.toInt()
                    
                    while (k <= 'z'.toInt()) {
                        val arr = word.toCharArray()
                        arr[j] = k.toChar()
                        
                        val str = String(arr)
                        
                        if (set.contains(str) && !visited.contains(str)) {
                            queue.add(str)
                            visited.add(str)
                        }
                        
                        k++
                    }
                }
            }
            
            ++changes
        }
        return 0
    }
}