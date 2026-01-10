class Solution {
    int dp[][];
    public int solve(int i,  int j, String s1, String s2) {
        if(i==0 && j==0) return 0;
        if(i==0) {
            int temp=0;
            for(int k=j;k>0;k--) temp += (int)s2.charAt(k-1);
            return temp;
        }
        if(j==0) {
            int temp=0;
            for(int k=i;k>0;k--) temp += (int)s1.charAt(k-1);
            return temp;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1)) return solve(i-1, j-1, s1, s2);

        int x = (int)s1.charAt(i-1) + solve(i-1, j, s1, s2);
        int y = (int)s2.charAt(j-1) + solve(i, j-1, s1, s2);

        return dp[i][j] = Math.min(x, y);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m+1][n+1];
        for(int[]row: dp) Arrays.fill(row, -1);
        return solve(m, n, s1, s2);

        
    }
}