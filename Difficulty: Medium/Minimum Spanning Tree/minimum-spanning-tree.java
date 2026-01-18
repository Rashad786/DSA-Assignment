record Pair(int node, int wt){}

class Solution {
    public int spanningTree(int V, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        boolean[] vis = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.wt()-y.wt());
        pq.offer(new Pair(0, 0));
        
        int sum = 0;
        while(pq.size() != 0) {
            Pair pair = pq.poll();
            int edgewt = pair.wt();
            int node = pair.node();
            
            if(vis[node]) continue;
            
            vis[node]=true;
            sum += edgewt;
            
            for(Pair it: adj.get(node)){
                int adjNode = it.node();
                int edjWt = it.wt();
                if(!vis[adjNode]) {
                    pq.offer(new Pair(adjNode, edjWt));
                }
            }
        }
        return sum;
    }
}
