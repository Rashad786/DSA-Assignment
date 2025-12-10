class Solution {
    int MOD = 1000000007;
    public int fact(int n) {
        long f=1;
        for(int i=1;i<=n;i++) f = (f*i) % MOD;
        return (int)f;
    }
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            min = Math.min(min, complexity[i]);
        }

        int cnt=0;
        for(int i=0;i<n;i++) {
            if(complexity[i]==min) cnt++;
        }

        return (cnt>1 || min!=complexity[0]) ? 0 : fact(n-1);
    }
}