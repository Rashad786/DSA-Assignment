class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {
            if(nums[i]>max) {
                smax = max;
                max = nums[i];
            }else if(nums[i]>smax) {
                smax = nums[i];
            }
            if(nums[i]<min) {
                min = nums[i];
            }
        }

        return max + smax - min;
    }
}