class Solution {
    public long getDescentPeriods(int[] prices) {
        int n=prices.length;
        int i=0;
        int j=0;
        long ans=0;
        while(j<n) {
            if(i==j || prices[j-1]-prices[j]==1) {
                ans += j-i+1;
                j++;
            }
            else{
                i=j;
            }
        }
        return ans;
    }
}