class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> st = new HashSet<>();
        for(int num: nums) st.add(num);
        while(st.contains(original)) {
            original *= 2;
        }
        return original;

        // Arrays.sort(nums);
        // int n = nums.length;
        // while(true) {
        //     int low=0;
        //     int high = n-1;
        //     int idx = -1;
        //     while(low<=high) {
        //         int mid = (low+high)/2;
        //         if(nums[mid]==original) {
        //             idx=mid;
        //             break;
        //         }
        //         else if(nums[mid]>original) high = mid-1;
        //         else low = mid+1;
        //     }
        //     if(idx == -1) return original;
        //     else original *= 2;
        // }
    }
}