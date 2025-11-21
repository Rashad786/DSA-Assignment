class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int[][] hash = new int[26][2];
        for(int[]row: hash) Arrays.fill(row, -1);

        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            int idx = ch-'a';
            if(hash[idx][0]==-1) hash[idx][0] = i;
            hash[idx][1] = i;
        }

        int cnt=0;
        for(int i=0;i<26;i++) {


            int leftIdx = hash[i][0];
            int rightIdx = hash[i][1];

            if(leftIdx==-1) continue;

            Set<Character> st = new HashSet<>();
            for(int mid=leftIdx+1;mid<rightIdx;mid++) {
                st.add(s.charAt(mid));
            }
            cnt += st.size();
        }
        return cnt;
    }
}