class Solution {
    public int specialTriplets(int[] nums) {
        long MOD = 1_000_000_007L;
        int n = nums.length;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for(int num: nums) {
            right.put(num, right.getOrDefault(num, 0)+1);
        }

        long ans=0;
        for(int i=0;i<n;i++) {
            int x = nums[i];
            int req = 2*x;

            right.put(x, right.get(x)-1);

            long leftCnt = left.getOrDefault(req, 0);
            long rightCnt = right.getOrDefault(req, 0);
            ans = (ans + leftCnt*rightCnt) % MOD;

            left.put(x, left.getOrDefault(x, 0)+1);
        }
        return (int)ans;
    }
}