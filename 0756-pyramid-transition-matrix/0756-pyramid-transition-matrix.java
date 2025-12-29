class Solution {
    public boolean solve(int idx, String bottom, String curr, Map<String, List<Character>> allowed) {
        if(bottom.length()==1) {
            return true;
        }

        if(idx==bottom.length()-1) {
            return solve(0, curr, "", allowed);
        }

        String key = "" + bottom.charAt(idx) + bottom.charAt(idx + 1);
        if (!allowed.containsKey(key)) return false;

        for(char top: allowed.get(key)) {
            if(solve(idx+1, bottom, curr+top, allowed)) return true;
        }

        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> mpp = new HashMap<>();
        for(String s: allowed) {
            String key = "" + s.charAt(0) + s.charAt(1);
            mpp.computeIfAbsent(key, k->new ArrayList<>()).add(s.charAt(2));
        }

        return solve(0, bottom, "", mpp);
    }
}