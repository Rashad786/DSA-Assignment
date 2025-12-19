class Solution {
    int[] parent;
    int[] rank;
    public int find(int node) {
        if(parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    public void union(int u, int v) {
        int par_u = find(u);
        int par_v = find(v);
        if(par_u==par_v) return;
        if(rank[par_u] > rank[par_v]) {
            parent[par_v] = par_u;
        }
        else if(rank[par_u] < rank[par_v]) {
            parent[par_u] = par_v;
        }
        else{
            parent[par_v] = par_u;
            rank[par_u]++;
        }
    }
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        parent=new int[V];
        rank=new int[V];
        
        for(int i=0;i<V;i++) parent[i] = i;
        
        for(int i=0;i<V;i++) {
            for(int it: adj.get(i)) {
                if(i>it) continue; 
                int par_u = find(i);
                int par_v = find(it);
                if(par_u==par_v) return 1;
                union(par_u, par_v);
            }
        }
        return 0;
    }
}