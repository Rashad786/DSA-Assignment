class Solution {
    int[][] dp;
    // public int solve(int i, int mod, int[] nums) {
    //     if(i<0) return mod==0 ? mod : Integer.MIN_VALUE;

    //     if(dp[i][mod]!=-1) return dp[i][mod];

    //     int notpick = solve(i-1, mod, nums);
    //     int pick = nums[i] + solve(i-1, (mod + (nums[i]%3))%3, nums);

    //     return dp[i][mod] = Math.max(notpick, pick);
    // }
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        dp = new int[n+1][3];
        // for(int[]row: dp) Arrays.fill(row, -1);
        // return solve(n-1, 0, nums);

        dp[0][0] = 0;
        dp[0][1] = dp[0][2] = Integer.MIN_VALUE;

        for(int i=1;i<=n;i++) {
            for(int mod=2;mod>=0;mod--) {
                int notpick = dp[i-1][mod];
                int pick = nums[i-1] + dp[i-1][(mod + (nums[i-1]%3))%3];

                dp[i][mod] = Math.max(notpick, pick);
            }
        }
        return dp[n][0];
    }
}