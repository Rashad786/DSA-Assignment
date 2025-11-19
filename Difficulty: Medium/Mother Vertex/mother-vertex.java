
class Solution {
    // Function to find a Mother Vertex in the Graph.
    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node]=true;
        for(int it: adj.get(node)) {
            if(!vis[it]) {
                dfs(it, vis, adj);
            }
        }
    } 
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        int mother = -1;
        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                dfs(i, vis, adj);
                mother = i;
            }
        }
        
        if(mother==-1) return -1;
        
        vis = new boolean[V];
        dfs(mother, vis, adj);
        
        for(boolean it: vis) {
            if(!it) return -1;
        }
        
        return mother;
    }
}