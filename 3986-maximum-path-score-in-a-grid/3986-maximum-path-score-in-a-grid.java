class Solution {
    Integer[][][] dp;
    public int solve(int i, int j, int[][] grid, int remK) {
        int m=grid.length;
        int n=grid[0].length;

        if(i>=m || j>=n) return Integer.MIN_VALUE;

        int cost = grid[i][j]==0 ? 0 : 1;
        int score = grid[i][j];

        if(cost>remK) return Integer.MIN_VALUE;

        if(i==m-1 && j==n-1) return grid[i][j];

        if(dp[i][j][remK]!=null) return dp[i][j][remK];

        int right = solve(i, j+1, grid, remK-cost);
        int down = solve(i+1, j, grid, remK-cost);

        return dp[i][j][remK] = score + Math.max(right, down);
    }
    public int maxPathScore(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        dp = new Integer[m][n][k+1];
        int ans = solve(0, 0, grid, k);
        return ans<0 ? -1 : ans;
    }
}