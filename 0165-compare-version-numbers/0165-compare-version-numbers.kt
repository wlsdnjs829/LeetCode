class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val versionMap1 = mutableMapOf<Int, Int?>()
        val versionMap2 = mutableMapOf<Int, Int?>()

        version1.split(".")
            .forEachIndexed { index, version -> versionMap1[index] = version.toIntOrNull() }

        version2.split(".")
            .forEachIndexed { index, version -> versionMap2[index] = version.toIntOrNull() }

        val maxSize = versionMap1.size.coerceAtLeast(versionMap2.size)

        for (index in 0..maxSize) {
            val value1 = versionMap1[index] ?: 0
            val value2 = versionMap2[index] ?: 0

            when {
                value1 > value2 -> return 1
                value1 < value2 -> return -1
                else -> Unit
            }
        }

        return 0
    }
}