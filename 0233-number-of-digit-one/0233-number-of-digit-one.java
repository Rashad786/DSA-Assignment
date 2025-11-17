class Solution {
    int dp[][][];
    public int solve(int idx, int tight, int cnt, String s) {
        if(idx == s.length()) return cnt;

        if(dp[idx][tight][cnt]!=-1) return dp[idx][tight][cnt];

        int limit = tight == 1 ? s.charAt(idx) - '0' : 9;
        int ans=0;
        for(int i=0;i<=limit;i++) {
            int newCnt = cnt + (i==1 ? 1 : 0);
            int newTight = tight==1 && (i == s.charAt(idx) - '0') ? 1 : 0;
            ans += solve(idx+1, newTight, newCnt, s); 
        }
        return dp[idx][tight][cnt] = ans;
    }
    public int countDigitOne(int n) {
        dp = new int [11][2][11];
        for(int[][]a: dp) {
            for(int[]b: a) Arrays.fill(b, -1);
        }
        String s = String.valueOf(n);
        int right = solve(0, 1, 0, s);
        return right;
    }
}