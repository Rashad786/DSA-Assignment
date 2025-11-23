class Solution {
    int[][] dp;
    public int solve(int i, int mod, int[] nums) {
        if(i<0) return mod==0 ? mod : Integer.MIN_VALUE;

        if(dp[i][mod]!=Integer.MIN_VALUE) return dp[i][mod];

        int notpick = solve(i-1, mod, nums);
        int pick = nums[i] + solve(i-1, (mod + (nums[i]%3))%3, nums);

        return dp[i][mod] = Math.max(notpick, pick);
    }
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        dp = new int[n][3];
        for(int[]row: dp) Arrays.fill(row, Integer.MIN_VALUE);
        return solve(n-1, 0, nums);
        // int ans=0;
        // for(int i=0;i<n;i++) {
        //     for(int j=0;j<dp[i].length;j++) {
        //         if(dp[i][j]!=Integer.MIN_VALUE) ans = Math.max(ans, dp[i][j]);
        //     }
        // }
        // return ans;
    }
}