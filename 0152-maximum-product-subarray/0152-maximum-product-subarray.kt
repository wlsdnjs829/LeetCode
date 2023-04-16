class Solution {
    fun maxProduct(nums: IntArray): Int {
        var minM = nums[0];
        var maxM = nums[0];
        var result = nums[0];

        for(index in 1..(nums.size-1)) {
            val num = nums[index];
            val tempMinM = Math.min(num, Math.min(minM*num, maxM*num));
            maxM = Math.max(num, Math.max(maxM*num, minM*num));
            minM = tempMinM; 
            result = Math.max(result, maxM);
        }
        
        return result;
    }
}