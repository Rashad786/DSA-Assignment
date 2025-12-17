class Solution {
    int[] dp;
    // public int fibo(int n) {
    //     if(n==0) return 0;
    //     else if(n==1 || n==2) return 1;
    //     if(dp[n]!=-1) return dp[n];
    //     return dp[n] = fibo(n-1)+fibo(n-2)+fibo(n-3);
    // }
    public int tribonacci(int n) {
        // dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return fibo(n);

        if(n==0) return 0;
        else if(n==1 || n==2) return 1;

        // dp[0]=0; dp[1]=dp[2]=1;
        // for(int i=3;i<=n;i++) {
        //     dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        // }
        // return dp[n];

        int first=0; int second=1; int third=1;
        int ans = 0;
        for(int i=3;i<=n;i++) {
            ans = first + second + third;
            first = second;
            second = third;
            third = ans;  
        }
        return ans;
    }
}