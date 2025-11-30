class Solution {
    public int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + (num % 10);
            num /= 10;
        }
        return rev;
    }
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int rev = reverse(nums[i]);

            if(mpp.containsKey(nums[i])) {
               int j = mpp.get(nums[i]);
               ans = Math.min(ans, Math.abs(i-j));
            }

            mpp.put(rev, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}