class Solution {
    public double lArea(double mid, int[][] squares) {
        double lower=0;
        for(int i=0;i<squares.length;i++) {
            int y = squares[i][1];
            int s = squares[i][2];
            if(y+s<=mid) lower += (double)s*s;
            else if(y<mid) lower += (mid-y)*s;
        }
        System.out.println(lower);
        return lower;
    }
    public double separateSquares(int[][] squares) {
        int n=squares.length;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        double tArea=0;

        for(int i=0;i<n;i++) {
            low = Math.min(low, squares[i][1]);
            high = Math.max(high, squares[i][1]+squares[i][2]);
            tArea += (double)squares[i][2]*squares[i][2];
        }

        for (int i = 0; i < 100; i++) {
            double mid = low + (high - low) / 2.0;
            double cArea = lArea(mid, squares);
            if(cArea < tArea/2.0) low=mid;
            else high=mid;
        }
        return high;
    }
}