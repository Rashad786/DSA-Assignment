class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int max = 0;
        int min = 0;
        for(int i=0;i<n;i++) {
            if(nums[i]>nums[max]) max=i;
            if(nums[i]<nums[min]) min=i;
        }

        int res = Math.min(Math.max(max, min)+1, n - Math.min(max, min));

        return Math.min(res, Math.min(max+1, n-max) + Math.min(min+1, n-min));
    }
}