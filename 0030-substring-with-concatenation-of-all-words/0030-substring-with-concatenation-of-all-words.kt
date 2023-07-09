class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val indices: MutableList<Int> = ArrayList()

        if (s.isEmpty() || words.isEmpty()) {
            return indices
        }

        val wordCount: MutableMap<String, Int> = HashMap()
        
        for (word in words) {
            wordCount[word] = wordCount.getOrDefault(word, 0) + 1
        }
        
        val wordLength = words[0].length
        val wordArrayLength = wordLength * words.size
        
        for (i in 0..s.length - wordArrayLength) {
            val current = s.substring(i, i + wordArrayLength)
            val wordMap: MutableMap<String, Int> = HashMap()

            var index = 0
            var j = 0
            
            while (index < words.size) {
                val part = current.substring(j, j + wordLength)
                wordMap[part] = wordMap.getOrDefault(part, 0) + 1
                j += wordLength
                index++
            }
            
            if (wordCount == wordMap) {
                indices.add(i)
            }
        }
        
        return indices
    }
}