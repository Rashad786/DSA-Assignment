class Solution {
    public int minDeletionSize(String[] strs) {
        int ans=0;
        int n=strs.length;
        for(int i=0;i<strs[0].length();i++) {
            char prev = '@';
            for(int j=0;j<n;j++) {
                if(strs[j].charAt(i) >= prev) {
                    prev = strs[j].charAt(i) ;
                }else{
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}