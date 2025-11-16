class Solution {
    public int numSub(String s) {
        int n = s.length();
        int mod = 1000000007;

        int i=0;
        int j=0;
        int ans=0;
        while(j<n) {
            if(s.charAt(j)=='0') {
                while(j<n && s.charAt(j)=='0') j++;
                i=j;
            }else{
                ans = (ans + j-i+1) % mod;
                j++;
            }
        }

        return ans;
    }

}