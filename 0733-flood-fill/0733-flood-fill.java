class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    public boolean isValid(int i, int j, int n, int m) {
        return i>=0 && i<n && j>=0 && j<m;
    }
    public void dfs(int sr, int sc, int oColor, int nColor, boolean[][] vis, int[][] image) {
        int n = image.length;
        int m = image[0].length;

        for(int i=0;i<4;i++) {
            int row = sr + dr[i];
            int col = sc + dc[i];
            if(isValid(row, col, n, m) && image[row][col]==oColor && !vis[row][col]) {
                image[row][col] = nColor;
                vis[row][col] = true;
                dfs(row, col, oColor, nColor, vis, image);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        dfs(sr, sc, oldColor, color, vis, image);
        return image;
    }
}