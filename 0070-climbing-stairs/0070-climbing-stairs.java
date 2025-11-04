class Solution {
    // Memoization

    // public int solve(int n, int[] dp) {
    //     if(n==0) return 1;

    //     if(dp[n]!=-1) return dp[n];

    //     int one = 0; int two = 0;
    //     if(n>0) one = solve(n-1, dp);
    //     if(n>1) two = solve(n-2, dp);

    //     return dp[n] = one + two;
    // }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return solve(n, dp);

        // Tabulation
        dp[0] = 1;
        for(int i=1;i<=n;i++) {
            int one = 0; int two = 0;
            if(i>0) one = dp[i-1];
            if(i>1) two = dp[i-2];

            dp[i] = one + two;
        }
        return dp[n];
    }
}