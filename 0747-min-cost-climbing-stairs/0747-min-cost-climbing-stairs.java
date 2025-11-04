class Solution {
    // Memoization

    // public int solve(int i, int n, int[] cost, int[] dp) {
    //     if(i>=n) return 0;

    //     if(dp[i]!=-1) return dp[i];

    //     int one = solve(i+1, n, cost, dp); 
    //     int two = solve(i+2, n, cost, dp);

    //     return dp[i] = cost[i] + Math.min(one, two);
    // }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return Math.min(solve(0, n, cost, dp), solve(1, n, cost, dp));

        // Tabulation
        dp[n] = 0;
        dp[n-1] = cost[n-1];
        for(int i=n-2;i>=0;i--) {
            int one = dp[i+1]; 
            int two = dp[i+2];

            dp[i] = cost[i] + Math.min(one, two);
        }
        return Math.min(dp[0], dp[1]);
    }
}