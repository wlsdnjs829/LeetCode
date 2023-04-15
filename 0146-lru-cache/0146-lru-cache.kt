class LRUCache(private val capacity: Int) {
    val map = LinkedHashMap<Int, Int>()

    fun get(key: Int): Int {
        val value = map[key]

        return if (value == null) -1 else {
            map.remove(key = key)
            map[key] = value
            value
        }
    }

    fun put(key: Int, value: Int) {
        map.remove(key = key)
        map[key] = value

        if (map.size > capacity) map.remove(key = map.keys.first())
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */