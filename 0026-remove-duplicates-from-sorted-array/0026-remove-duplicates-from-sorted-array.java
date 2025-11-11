class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;

        int i=1;
        int j=1;
        while(j<n) {
            while(j<n && nums[j]==nums[j-1]) {
                j++;
            }
            if(j<n) nums[i++] = nums[j++];
        }
        return i;
    }
}