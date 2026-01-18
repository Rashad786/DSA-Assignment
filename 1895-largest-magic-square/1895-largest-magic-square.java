class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int k=Math.min(n, m);

        int[][] rSum = new int[n][m];
        int[][] cSum = new int[n][m];

        for(int i=0;i<n;i++) {
            rSum[i][0] = grid[i][0];
            for(int j=1;j<m;j++) {
                rSum[i][j] = rSum[i][j-1] + grid[i][j];
            }
        }
        for(int j=0;j<m;j++) {
            cSum[0][j] = grid[0][j];
            for(int i=1;i<n;i++) {
                cSum[i][j] = cSum[i-1][j] + grid[i][j];
            }
        }

        while(k!=1) {
            for(int i=0;i<=n-k;i++) {
                for(int j=0;j<=m-k;j++) {
                    int target = rSum[i][j+k-1] - (j>0 ? rSum[i][j-1] : 0);

                    //rows
                    boolean allSame = true;
                    for(int l=i;l<i+k;l++) {
                        int sum = rSum[l][j+k-1] - (j>0 ? rSum[l][j-1] : 0);

                        if(sum!=target) {
                            allSame=false;
                            break;
                        }
                    }   

                    if(!allSame) continue;

                    // cols
                    for(int l=j;l<j+k;l++) {
                        int sum = cSum[i+k-1][l] - (i>0 ? cSum[i-1][l] : 0);

                        if(sum!=target) {
                            allSame=false;
                            break;
                        }
                    } 

                    if(!allSame) continue;

                    // diagonal
                    int dia=0;
                    int antiDia=0;
                    for(int l=0;l<k;l++) {
                        dia += grid[i+l][j+l];
                        antiDia += grid[i+l][j+k-1-l];
                    }

                    if(dia!=target || antiDia!=target) continue;

                    return k;
                }
            }
            k--;
        }
        return 1;
    }
}