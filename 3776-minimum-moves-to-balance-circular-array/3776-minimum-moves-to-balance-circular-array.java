class Solution {
    public long minMoves(int[] balance) {
        int n = balance.length;
        int idx = -1;
        long sum=0;

        for(int i=0;i<n;i++) {
            sum += balance[i];
            if(balance[i]<0) {
                idx = i;
            }
        }

        if(idx==-1) return 0;
        if(sum<0) return -1;

        int val=balance[idx];
        int dis=1;
        long ans = 0;

        while(val<0) {
            int left = (idx-dis+n)%n;
            int right = (idx+dis)%n;

            long available = (long) balance[left] + balance[right];

            if(left==right) {
                available -= balance[left];
            }
            long need = -val;
            long taken = Math.min(need, available);

            ans += taken*dis;
            val += taken;
            dis++;
        }
        return ans;
    }
}