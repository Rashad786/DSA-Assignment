class Solution {
    // public int solve(int i, int j, String s, String t, int[][] dp) {
    //     if(j==0) return 1;
    //     if(i==0) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     if(s.charAt(i-1)==t.charAt(j-1)) 
    //         return dp[i][j] = solve(i-1, j-1, s, t, dp) + solve(i-1, j, s, t, dp);
        
    //     return dp[i][j] = solve(i-1, j, s, t, dp);
    // } 
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp= new int[m+1][n+1];
        // for(int[]row: dp) Arrays.fill(row, -1);
        // return solve(m, n, s, t, dp);

        for(int i=0;i<m;i++) dp[i][0] = 1;

        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1)==t.charAt(j-1)) 
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[m][n];
    }
}