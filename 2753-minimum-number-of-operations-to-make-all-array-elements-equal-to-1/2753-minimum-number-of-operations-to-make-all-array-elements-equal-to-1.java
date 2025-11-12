class Solution {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
    public int minOperations(int[] nums) {
        int n = nums.length;

        int currGcd = nums[0];
        for (int num : nums) {
            currGcd = gcd(currGcd, num);
        }

        if(currGcd>1) return -1;

        int ones = 0;
        for (int num : nums)
            if (num == 1) ones++;
        if (ones > 0) return n - ones;  

        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int gcd_ = nums[i];
            for(int j=i;j<n;j++) {
                gcd_ = gcd(gcd_, nums[j]);
                if(gcd_ == 1) {
                    minLen = Math.min(minLen, j-i+1);
                }
            }
        }
        return (minLen-1) + (n-1);
    }
}