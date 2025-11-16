class Solution {
    public int numSub(String s) {
        int n = s.length();
        int[] prefix = new int[n];
        int mod = 1000000007;

        if(s.charAt(0)=='1') prefix[0] = 1;
        for(int i=1;i<n;i++) {
            if(s.charAt(i)=='1')
                prefix[i]  = 1 + prefix[i-1];
        }

        int i=0;
        int j=0;
        int ans=0;
        while(j<n) {
            if(prefix[j]==0) {
                while(j<n && prefix[j]==0)j++;
                i=j;
            }else{
                ans = (ans + j-i+1) % mod;
                j++;
            }
        }

        return ans;
    }

}