class Solution {
    public int solve(int i, int j, String s, String t, int[][] dp) {
        if(j<0) return 1;
        if(i<0 && j>=0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int ans=0;
        if(s.charAt(i)==t.charAt(j)) 
            ans += solve(i-1, j-1, s, t, dp);

        ans += solve(i-1, j, s, t, dp); 
        return dp[i][j] = ans; 
    } 
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp= new int[m][n];
        for(int[]row: dp) Arrays.fill(row, -1);
        return solve(m-1, n-1, s, t, dp);
    }
}