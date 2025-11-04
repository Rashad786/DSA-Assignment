class Solution {
    public int solve(int i, int j, int[][] mat, int[][] dp) {
        if(i<0 || i>=mat.length) return 0;
        if(j == mat[0].length) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int upRight = solve(i-1, j+1, mat, dp);
        int up = solve(i, j+1, mat, dp);
        int upLeft = solve(i+1, j+1, mat, dp);
        
        return dp[i][j] = mat[i][j] + Math.max(up, Math.max(upRight, upLeft));
    }
    public int maxGold(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i], -1);
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
            ans = Math.max(ans, solve(i, 0, mat, dp));
            
        return ans;
    }
}