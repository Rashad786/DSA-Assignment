class Solution {
    public int smallestRepunitDivByK(int k) {
        int len = 0;
        int num = 1;
        while(len<k) {
            int rem = num%k;
            len++;
            if(rem==0) return len;
            num = (rem*10)+1;
        }
        return -1;
    }
}