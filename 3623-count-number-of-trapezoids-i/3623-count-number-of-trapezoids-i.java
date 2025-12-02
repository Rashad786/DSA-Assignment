class Solution {
    private static final int MOD = (int)1e9 + 7;
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        Map<Integer, Integer> mpp = new HashMap<>();

        for(int i=0;i<n;i++) {
            int h = points[i][1];
            mpp.put(h, mpp.getOrDefault(h, 0)+1);
        }

        long ans = 0;
        long edgeSum = 0;
        for(Map.Entry<Integer, Integer> e: mpp.entrySet()) {
            int val = e.getValue();
            long edges = (long)val*(val-1)/2;
            ans = (ans + edges * edgeSum)%MOD;
            edgeSum += edges;
            
        }

        return (int)ans;
    }
}
