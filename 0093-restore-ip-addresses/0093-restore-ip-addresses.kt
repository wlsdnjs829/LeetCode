class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        return s.generate(1)
            .filter { it.length == s.length + 3 }
    }

    private fun String.generate(depth: Int): List<String> {
        if (depth == 5) {
            return listOf()
        }

        val answer = mutableListOf<String>()

        if (isNotEmpty()) {
            val substring = this.substring(length - 1, length)

            answer.addAll(
                this.substring(0, length - 1)
                    .generate(depth + 1)
                    .map { "$it.$substring" }
                    .takeIf { it.isNotEmpty() }
                    ?: listOf(substring)
            )
        }

        if (length > 1) {
            val substring = this.substring(length - 2, length)

            if (substring[0] != '0') {
                answer.addAll(
                    this.substring(0, length - 2)
                        .generate(depth + 1)
                        .map { "$it.$substring" }
                        .takeIf { it.isNotEmpty() }
                        ?: listOf(substring)
                )
            }
        }

        if (length > 2) {
            val substring = this.substring(length - 3, length)

            if (substring[0] != '0' && substring.toInt() < 256) {
                answer.addAll(
                    this.substring(0, length - 3)
                        .generate(depth + 1)
                        .map { "$it.$substring" }
                        .takeIf { it.isNotEmpty() }
                        ?: listOf(substring)
                )
            }
        }

        return answer
    }
}