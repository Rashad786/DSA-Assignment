class Solution {
    int[] dp;
    public int solve(int i, int[] nums) {
        // if(i>=nums.length) return Integer.MAX_VALUE;
        if(i>=nums.length-1) return 0;
        // if(nums[i]==0) return Integer.MAX_VALUE;

        if(dp[i]!=-1) return dp[i];

        int ans = Integer.MAX_VALUE;

        for(int idx=1;idx<=nums[i];idx++) {
            int steps = solve(i+idx, nums);
            if(steps!=Integer.MAX_VALUE) {
                ans = Math.min(ans, 1+steps);
            }
        }
        return dp[i] = ans;
    }
    public int jump(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, nums);
    }
}