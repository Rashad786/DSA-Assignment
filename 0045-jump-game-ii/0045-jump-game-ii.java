class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[n-1] = 0;
        for(int i=n-2;i>=0;i--) {
            int ans = Integer.MAX_VALUE;
            for(int idx=1;idx<=nums[i] && i+idx<n;idx++) {
                int steps = dp[i+idx];
                if(steps!=Integer.MAX_VALUE) {
                    ans = Math.min(ans, 1+steps);
                }
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}