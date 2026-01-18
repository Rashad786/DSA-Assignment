class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] ans = matrix;
        for(int j=0;j<n;j++) {
            int max=0;
            List<Integer> idx=new ArrayList<>();
            for(int i=0;i<m;i++) {
                max = Math.max(max, matrix[i][j]);
                if(matrix[i][j]==-1) idx.add(i);
            }
            for(int index: idx) ans[index][j]=max;
        }
        return ans;
    }
}