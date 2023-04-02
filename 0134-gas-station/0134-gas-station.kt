class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var sum = 0
        var minSum = gas.first()
        var ind = -1

        for (index in gas.indices) {
            sum += gas[index] - cost[index]

            if (sum < minSum) {
                minSum = sum
                ind = (index + 1) % gas.size
            }
        }

        return if (sum < 0) -1 else ind
    }
}