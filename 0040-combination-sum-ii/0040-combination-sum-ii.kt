class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        
        val result = mutableListOf<List<Int>>()
        
        fun help(index: Int, pattern: List<Int>) {
            if (pattern.sum() > target) return
            
            if (index == candidates.size) {
                if (pattern.sum() == target) result.add(pattern)
                return
            }
            
            help(index + 1, pattern + candidates[index])
            
            var _index = index
            
            while (_index < candidates.size - 1 && candidates[_index] == candidates[_index + 1]) {
                _index += 1
            }
            
            help(_index + 1, pattern)
        }
        
        help(0, emptyList())
        return result
    }
}