class Solution {
    // Memoization

    // public int solve(int e, int f, int[][] dp) {
    //     if(f==0 || f==1) return f;
    //     if(e==1) return f;

    //     if(dp[e][f]!=-1) return dp[e][f];

    //     int min = Integer.MAX_VALUE;
    //     int low=1; int high=f; 
    //     while(low<=high) {
    //         int mid = (low+high)/2;
    //         int broke = solve(e-1, mid-1, dp);
    //         int notbroke = solve(e, f-mid, dp);
    //         int worst = Math.max(broke, notbroke);
    //         min = Math.min(min, 1 + worst);

    //         if(broke > notbroke) {
    //             high = mid-1;
    //         }else{
    //             low = mid+1;
    //         }
    //     }

    //     return dp[e][f] = min;
    // }
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        // for(int[]row: dp) Arrays.fill(row, -1);
        // return solve(k, n, dp);

        // Tabulation
        for(int i=0;i<=n;i++) dp[1][i] = i;
        for(int i=0;i<=k;i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for(int e=2;e<=k;e++) {
            for(int f=2;f<=n;f++) {
                int min = Integer.MAX_VALUE;
                int low=1; int high=f; 
                while(low<=high) {
                    int mid = (low+high)/2;
                    int broke = dp[e-1][mid-1];
                    int notbroke = dp[e][f-mid];
                    int worst = Math.max(broke, notbroke);
                    min = Math.min(min, 1 + worst);

                    if(broke > notbroke) {
                        high = mid-1;
                    }else{
                        low = mid+1;
                    }
                }

                dp[e][f] = min;
            }
        }

        return dp[k][n];
    }
}