class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length;
        
        long ans=0;
        for(int i=0;i<n;i++) ans += prices[i] * strategy[i];
        
        int i=0;
        int j=0;
        long res = ans;
        long max = Long.MIN_VALUE;
        while(j<n) {
            if(j-i+1 > k) {
                max = Math.max(max, ans);
                int mid = i+k/2;
                ans -= prices[mid];
                ans += prices[i] * strategy[i];
                i++;
            }

            long remove = prices[j] * strategy[j];
            ans = remove>=0 ? ans-remove : ans+Math.abs(remove);
            if(j-i+1 > k/2){
                ans += prices[j];
            }
            j++;
        }
        max = Math.max(max, ans);

        return Math.max(max, res);
        
    }
}