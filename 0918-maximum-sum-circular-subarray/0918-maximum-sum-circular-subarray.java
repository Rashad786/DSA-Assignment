class Solution {
    public int kadaneMax(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum = Math.max(nums[i], sum+nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
    public int kadaneMin(int[] nums) {
        int n = nums.length;
        int minSum = nums[0];
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum = Math.min(nums[i], sum+nums[i]);
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;

        int maxSum = kadaneMax(nums);
        int minSum = kadaneMin(nums);
        int cSum = sum - minSum;

        if(maxSum > 0)
            return Math.max(maxSum, cSum);
        return maxSum;
    }
}