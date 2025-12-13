class Solution {
    public boolean isValid(String code) {
        if(code.length()==0) return false;
        for(int i=0;i<code.length();i++) {
            char ch = code.charAt(i);
            if((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z') || (ch>='0'&&ch<='9') || ch=='_') continue;
            else return false;
        }
        return true;
    }

    public void add(String key, Map<String, List<String>> mpp, List<String> ans) {
        List<String> temp = mpp.get(key);
        Collections.sort(temp);
        for(String s: temp) ans.add(s);
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        Map<String, List<String>> mpp = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(isActive[i] && isValid(code[i])) 
                mpp.computeIfAbsent(businessLine[i],k->new ArrayList<>()).add(code[i]);
        }

        List<String> ans = new ArrayList<>();
        if(mpp.containsKey("electronics")) {
            add("electronics", mpp, ans);
        }
        if(mpp.containsKey("grocery")) {
            add("grocery", mpp, ans);
        }
        if(mpp.containsKey("pharmacy")) {
            add("pharmacy", mpp, ans);
        }
        if(mpp.containsKey("restaurant")) {
            add("restaurant", mpp, ans);
        }

        return ans;
    }
}