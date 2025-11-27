class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        int[] hash = new int[101];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            hash[nums[i]]++;
            max = Math.max(max, hash[nums[i]]);
        }
        int cnt=0;
        for(int i=0;i<=100;i++) {
            if(hash[i]==max) cnt++;
        }
        return cnt*max;
    }
}