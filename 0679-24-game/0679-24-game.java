class Solution {
    double epsilon = 0.001;
    public List<Double> compute(double a, double b) {
        List<Double> possible = new ArrayList<>();

        possible.add(a+b);
        possible.add(a-b);
        possible.add(b-a);
        possible.add(a*b);
        possible.add(a/b);
        possible.add(b/a);

        return possible;
    }
    public boolean solve(List<Double> nums) {
        if(nums.size()==1) return Math.abs(nums.get(0)-24) < epsilon;

        for(int i=0;i<nums.size();i++) {
            for(int j=0;j<nums.size();j++) {
                if(i==j) continue;

                List<Double> next = new ArrayList<>();
                for(int k=0;k<nums.size();k++) {
                    if(k==i || k==j) continue;
                    next.add(nums.get(k));
                }

                double a = nums.get(i);
                double b = nums.get(j);

                for(double val: compute(a, b)) {
                    next.add(val);
                    if(solve(next)) return true;
                    next.remove(next.size()-1);
                }
            }
        }
        return false;
    }
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for(int num: cards) {
            nums.add((double) num);
        }

        return solve(nums);
    }
}