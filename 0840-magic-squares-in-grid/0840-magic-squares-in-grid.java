class Solution {
    public boolean isMagical(int i, int j, int[][] grid, boolean[] hash) {
        for(int row=i;row<i+3;row++) {
            for(int col=j;col<j+3;col++) {
                if(grid[row][col] > 9 || grid[row][col] == 0) return false;
                hash[grid[row][col]]=true;
            }
        }
        for(int k=1;k<10;k++) {
            if(!hash[k]) return false;
        }

        int sum = grid[i][j] + grid[i][j+1] + grid[i][j+2];

        return
            grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2] == sum &&
            grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2] == sum &&

            grid[i][j] + grid[i+1][j] + grid[i+2][j] == sum &&
            grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1] == sum &&
            grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2] == sum &&

            grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2] == sum &&
            grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j] == sum;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(n<3 || m<3) return 0;

        boolean[] hash = new boolean[10];

        int ans=0;
        for(int i=0;i<=n-3;i++) {
            for(int j=0;j<=m-3;j++) {
                if(isMagical(i, j, grid, hash)) ans++;
                Arrays.fill(hash, false);
            }
        }
        return ans;
    }
}