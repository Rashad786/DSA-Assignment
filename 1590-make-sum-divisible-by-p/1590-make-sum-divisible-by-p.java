class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long total = 0;
        for (int num : nums) total += num;

        long target = total % p;
        if (target == 0) return 0;

        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, -1);

        long curr = 0;
        int ans = n;
        for(int i=0;i<n;i++) {
            curr = (curr + nums[i]) % p;
            int need = (int)((curr - target + p) % p);

            if(mpp.containsKey(need)) {
                ans = Math.min(ans, i-mpp.get(need));
            }

            mpp.put((int)curr, i);
        }

        return ans == n ? -1: ans;
    }
}