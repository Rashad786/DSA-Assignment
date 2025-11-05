class Solution {
    // public boolean solve(int i, int j, String s, String p, Boolean[][] dp) {
    //     if(i==0 && j==0) return true;
    //     if(j==0 && i>0) return false;

    //     if(i==0 && j>0) {
    //         for(int k=j;k>0;k--) {
    //             if(p.charAt(k-1)!='*') return false;
    //         }
    //         return true;
    //     }

    //     if(dp[i][j] != null) return dp[i][j];

    //     if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
    //         if(solve(i-1, j-1, s, p, dp)) return dp[i][j] = true;
    //     }
    //     if(p.charAt(j-1) == '*') {
    //         return dp[i][j] = solve(i-1, j, s, p, dp) || solve(i, j-1, s, p, dp);
    //     }
        
    //     return dp[i][j] = false;
    // }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        // Boolean[][] dp = new Boolean[n+1][m+1];
        // return solve(n, m, s, p, dp);

        // Tabulation

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++) dp[i][0] = false;
        for(int j=1;j<=m;j++) {
            boolean flag = true;
            for(int k=j;k>0;k--) {
                if(p.charAt(k-1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    if(dp[i-1][j-1]) dp[i][j] = true;
                }
                else if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else dp[i][j] = false;
            }
        }

        return dp[n][m];
    }
}