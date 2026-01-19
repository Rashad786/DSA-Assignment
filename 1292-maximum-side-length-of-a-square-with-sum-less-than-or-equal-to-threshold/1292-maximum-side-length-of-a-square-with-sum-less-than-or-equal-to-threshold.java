class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length; int n=mat[0].length;
        int[][] pSum = new int[m][n];

        for(int i=0;i<m;i++) {
            pSum[i][0] = mat[i][0];
            for(int j=1;j<n;j++) {
                pSum[i][j] = pSum[i][j-1] + mat[i][j];
            }
        }

        for(int side=Math.min(m, n); side>0;side--) {
            for(int i=0;i<=m-side;i++) {
                for(int j=0;j<=n-side;j++) {
                    int sum=0;
                    for(int k=i;k<i+side;k++) {
                        sum += pSum[k][j+side-1] - (j>0 ? pSum[k][j-1] : 0);
                    }
                    if(sum <= threshold) return side;
                }
            }
        }
        return 0;

    }
}