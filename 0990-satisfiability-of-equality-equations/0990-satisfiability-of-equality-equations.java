class Solution {
    char[] parent;
    int[] rank;
    public char find(char node) {
        if(parent[node-'a']==node) {
            return parent[node-'a'];
        }
        return parent[node-'a'] = find(parent[node-'a']);
    }
    public void union(char u, char v) {
        char par_u = find(u);
        char par_v = find(v);
        if(par_u==par_v) return;     
        if(rank[par_u-'a'] > rank[par_v-'a']) {
            parent[par_v-'a'] = par_u;
        }
        else if(rank[par_u-'a'] < rank[par_v-'a']) {
            parent[par_u-'a'] = par_v;
        }
        else{
            rank[par_u-'a']++;
            parent[par_v-'a'] = par_u;
        }
    }
    public boolean equationsPossible(String[] equations) {
        parent = new char[26];
        rank = new int[26];
        for(char ch='a';ch<='z';ch++) {
            parent[ch-'a'] = ch;
        }

        for(String eq: equations) {
            char u = eq.charAt(0);
            char v = eq.charAt(3);
            char op = eq.charAt(1); 
            if(op=='=') {
                union(u, v);
            }
        }
        for(String eq: equations) {
            char u = eq.charAt(0);
            char v = eq.charAt(3);
            char op = eq.charAt(1); 
            if(op=='!') {
                char par_u = find(u);
                char par_v = find(v);
                if(par_u-'a' == par_v-'a') return false;
            }
        }
        return true;
    }
}