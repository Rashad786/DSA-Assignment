class Solution {
    // Memoization

    // public int solve(int n, int[] dp) {
    //     if(n==0 || n==1) return n;
    //     if(dp[n]!=-1) return dp[n];
    //     return dp[n] = solve(n-1, dp) + solve(n-2, dp);
    // }
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n+1];

        // Arrays.fill(dp, -1);
        // return solve(n, dp);

        // Tabulation
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}