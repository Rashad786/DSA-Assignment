class Solution {
    public boolean isPossible(int[] arr, int k, int mid) {
        int painter=1;
        int time=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > mid) return false;
            if(time+arr[i] <= mid) {
                time += arr[i];
            }else{
                time=arr[i];
                painter++;
                if(painter > k) return false;
            }
        }   
        return true;
    }
    public int search(int[] arr, int k) {
        int maxLen = 0, sum = 0;
        for(int len : arr) {
            maxLen = Math.max(maxLen, len);
            sum += len;
        }

        int low = maxLen, high = sum;
        int result = sum;
        
        while(low<=high) {
            int mid = (low+high)/2;
            if(isPossible(arr, k, mid)) {
                result = mid;     
                high = mid - 1;
            } else {
                low = mid + 1;    
            }
        }
        return result;
    }
    public int minTime(int[] arr, int k) {
        return search(arr, k);
        
    }
}
