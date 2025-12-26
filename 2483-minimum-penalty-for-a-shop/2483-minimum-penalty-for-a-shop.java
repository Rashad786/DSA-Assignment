class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int Y = 0;
        int N = 0;

        for(int i=0;i<n;i++) {
            if(customers.charAt(i)=='Y') Y++;
        }
        if(Y==0) return 0;

        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0;i<n;i++) {
            char ch = customers.charAt(i);
            if(min > N+Y) {
                min = N+Y;
                ans = i;
            }
            if(ch == 'Y') Y--;
            else N++;
        }
        if(ans==-1 || min > N) ans = n;
        return ans;
    }
}