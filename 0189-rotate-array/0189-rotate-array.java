class Solution {
    private void reverse(int si,int ei, int arr[]){
        for(int i=si,j=ei;i<j;i++,j--){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k==0 || k==n) return;
        k=k%n;
        reverse(0, n-1, nums);
        reverse(0, k-1, nums);
        reverse(k, n-1, nums);
    }
}