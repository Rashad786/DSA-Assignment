class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] pSum = new long[n];
        pSum[0] = nums[0];
        for(int i=1;i<n;i++) pSum[i] = pSum[i-1] + nums[i];

        long maxSum = Long.MIN_VALUE;
        for(int i=0;i<k;i++) {
            long currSum = 0;
            int start = i;
            while(start<n && start+k-1<n) {
                int end = start+k-1;
                long subSum = pSum[end] - (start>0 ? pSum[start-1] : 0);
                currSum = Math.max(subSum, currSum+subSum);
                maxSum = Math.max(maxSum, currSum);
                start += k;
            }
        }
        return maxSum;
    }
}