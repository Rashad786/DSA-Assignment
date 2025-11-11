class Solution {
    int[][][] dp;
    // public int solve(int i, int[][] arr, int m, int n) {
    //     if(i==0) return 0;

    //     if(dp[i][m][n]!=-1) return dp[i][m][n];

    //     int notpick = solve(i-1, arr, m, n);
    //     int pick = Integer.MIN_VALUE;
    //     if(m>=arr[i-1][0] && n>=arr[i-1][1]) pick = 1 + solve(i-1, arr, m-arr[i-1][0], n-arr[i-1][1]);

    //     return dp[i][m][n] = Math.max(pick, notpick);
    // }

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] arr = new int[len][2];
        dp = new int[len+1][m+1][n+1];
        // for (int i = 0; i <= len; i++) {
        //     for (int j = 0; j <= m; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }

        int idx=0;
        for(String str: strs) {
            for(char ch: str.toCharArray()) {
                if(ch=='0') arr[idx][0]++;
                else arr[idx][1]++;
            }
            idx++;
        }

        // return solve(len, arr, m, n);

        for(int i=1;i<=len;i++) {
            for(int j=0;j<=m;j++) {
                for(int k=0;k<=n;k++) {
                    int notpick = dp[i-1][j][k];
                    int pick = Integer.MIN_VALUE;
                    if(j>=arr[i-1][0] && k>=arr[i-1][1]) pick = 1 + dp[i-1][j-arr[i-1][0]][k-arr[i-1][1]];

                    dp[i][j][k] = Math.max(pick, notpick);
                }
            }
        }

        return dp[len][m][n];
    }
}