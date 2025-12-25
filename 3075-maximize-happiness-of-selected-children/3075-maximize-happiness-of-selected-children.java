class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans=0;
        int n=happiness.length;
        Arrays.sort(happiness);
        int dec=0;
        for(int i=n-1;i>=0 && k>0;i--) {
            int temp = happiness[i]-dec;
            if(temp>0) ans+=temp;
            else return ans;
            dec++; k--;
        }
        return ans;
    }
}