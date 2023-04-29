/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class BSTIterator(root: TreeNode?) {

    private val iterator = mutableListOf<Int>()
    private val stack = Stack<TreeNode>()
    private var count = 0
    
    init {
        var node = root

        while (node != null) {
            if (node.left != null) {
                stack.push(node)
                node = node.left
                continue
            }

            iterator.add(node.`val`)

            if (node.right != null) {
                node = node.right
                continue
            }

            if (stack.empty()) {
                if (node.right == null) {
                    node = null
                    continue
                }

                node = node.right
                continue
            }

            node = stack.pop()
            node.left = null
        }
    }

    fun next(): Int {
        val next = iterator[count]
        count++
        
        return next
    }

    fun hasNext(): Boolean = count < iterator.size

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */