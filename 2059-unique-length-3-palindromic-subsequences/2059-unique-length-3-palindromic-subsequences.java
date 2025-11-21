class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        Set<Character> letters = new HashSet<>();

        for(char letter: s.toCharArray()) letters.add(letter);

        int cnt=0;
        for(char letter: letters) {
            int leftIdx = -1;
            int rightIdx = -1;

            for(int i=0;i<n;i++) {
                if(s.charAt(i) == letter) {
                    if(leftIdx==-1) leftIdx = i;
                    rightIdx = i;
                }
            }

            Set<Character> st = new HashSet<>();
            for(int mid=leftIdx+1;mid<rightIdx;mid++) {
                st.add(s.charAt(mid));
            }
            cnt += st.size();
        }
        return cnt;
    }
}