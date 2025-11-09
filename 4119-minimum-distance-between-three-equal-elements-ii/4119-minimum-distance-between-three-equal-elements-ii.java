class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        Map<Integer, ArrayList<Integer>> mpp = new HashMap<>();
        for(int i=0;i<n;i++) {
            mpp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans=Integer.MAX_VALUE;
        for(Map.Entry<Integer, ArrayList<Integer>> e: mpp.entrySet()) {
            ArrayList<Integer> list = e.getValue();
            for(int i=0;i+3<=list.size();i++) {
                int a = list.get(i); int b = list.get(i+1); int c = list.get(i+2);
                int temp = Math.abs(a-b)+Math.abs(b-c)+Math.abs(c-a);
                ans = Math.min(ans, temp);
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}