class Solution {
    public int getMaxArea(int n, int[] arr) {
        int ans=2;
        Arrays.sort(arr);
        int cnt=1;
        for(int i=1;i<arr.length;i++) {
            if(arr[i]-arr[i-1]==1) {
                cnt++;
                ans = Math.max(ans, cnt+1);
            }else{
                cnt=1;
            }
        }
        return ans;
    }
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int x = getMaxArea(n, hBars);
        int y = getMaxArea(m, vBars);
        int side = Math.min(x, y);
        return side*side;
    }
}