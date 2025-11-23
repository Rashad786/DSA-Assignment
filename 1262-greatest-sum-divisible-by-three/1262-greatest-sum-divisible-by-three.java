class Solution {
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int sum=0;
        List<Integer> remain1 = new ArrayList<>();
        List<Integer> remain2 = new ArrayList<>();

        for(int num: nums) {
            sum += num;

            if(num%3==1) remain1.add(num);
            else if(num%3==2) remain2.add(num);
        }

        int rem = sum%3;
        if(rem==0) return sum;

        Collections.sort(remain1);
        Collections.sort(remain2);

        if(rem==1) {
            int remove1 = remain1.size()>=1 ? remain1.get(0) : Integer.MAX_VALUE;
            int remove2 = remain2.size()>=2 ? remain2.get(0)+remain2.get(1) : Integer.MAX_VALUE;

            sum -= Math.min(remove1, remove2);
        }
        else { // rem = 2
            int remove1 = remain2.size()>=1 ? remain2.get(0) : Integer.MAX_VALUE;
            int remove2 = remain1.size()>=2 ? remain1.get(0)+remain1.get(1) : Integer.MAX_VALUE;

            sum -= Math.min(remove1, remove2);
        }

        return sum<0 ? 0 : sum;
    }
}