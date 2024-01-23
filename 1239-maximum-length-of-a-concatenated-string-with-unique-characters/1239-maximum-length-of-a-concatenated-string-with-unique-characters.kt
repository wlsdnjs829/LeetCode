class Solution {
    
 private var maxLength = 0
    
 fun maxLength(arr: List<String>): Int {
    helper(arr, "", 0)
    return maxLength
 }

private fun helper(arr: List<String>, currentString: String, index: Int) {
    if (index >= arr.size) return
    if (currentString.toSet().size != currentString.length) return
    if (maxLength < currentString.length) maxLength = currentString.length
    
    for (i in index until arr.size) {
        helper(arr, currentString + arr[i], i)
    }
 }
}