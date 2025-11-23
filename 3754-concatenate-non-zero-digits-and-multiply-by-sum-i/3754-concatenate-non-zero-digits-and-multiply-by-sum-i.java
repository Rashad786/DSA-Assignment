class Solution {
    public long sumAndMultiply(int n) {
        long temp = 1;
        long digit = 0;
        long sum = 0;
        while(n!=0) {
            long ld = n%10;
            if(ld!=0) {
                digit = ld*temp + digit;
                temp *= 10;
                sum += ld;
            }
            n /= 10;
        }
        return digit*sum;
    }
}