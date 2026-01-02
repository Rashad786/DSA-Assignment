class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int num: nums) {
            mpp.put(num, mpp.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer, Integer> e: mpp.entrySet()) {
            if(e.getValue()>=n/2) return e.getKey();
        }
        return -1;
    }
}