class Solution {
    public int countTriples(int n) {
        int ans=0;
        for(int a=1;a<=250;a++) {
            for(int b=1;b<=250;b++) {
                int val = a*a + b*b;
                int c = (int)Math.sqrt(val);
                if(c<=n && c*c == val) ans++;
            }
        }
        return ans;
    }
}