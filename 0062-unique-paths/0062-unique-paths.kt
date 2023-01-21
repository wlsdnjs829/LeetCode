class Solution {
  fun uniquePaths(m: Int, n: Int): Int {
    val arrayListOf = arrayListOf<IntArray>()
    
    repeat(m) {
      arrayListOf.add(IntArray(n) { 1 })
    }
    
    for (i in 1 until m) {
      for (j in 1 until n) {
        arrayListOf[i][j] = arrayListOf[i - 1][j] + arrayListOf[i][j - 1]
      }
    }
    
    return arrayListOf[m - 1][n - 1]
  }
}