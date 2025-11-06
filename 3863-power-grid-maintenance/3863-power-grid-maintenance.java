class Solution {
    public void bfs(int station, List<List<Integer>> adj, boolean[] vis, int[] componentId, 
                    Map<Integer, TreeSet<Integer>> mpp) {
        Queue<Integer> q = new LinkedList<>();
        q.add(station);
        vis[station] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            mpp.computeIfAbsent(station, k -> new TreeSet<>()).add(curr);
            componentId[curr] = station;
            for(int it: adj.get(curr)) {
                if(!vis[it]) {
                    q.add(it);
                    vis[it] = true;
                }
            }
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, TreeSet<Integer>> mpp = new HashMap<>();
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=c;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] connection: connections) {
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] componentId = new int[c+1];
        boolean[] vis = new boolean[c+1];
        for(int i=1;i<=c;i++) {
            if(!vis[i])
                bfs(i, adj, vis, componentId, mpp);
        }

        HashSet<Integer> isOnline = new HashSet<>();
        for(int i=1;i<=c;i++) isOnline.add(i);

        for(int[]query: queries) {
            int type = query[0];
            int station = query[1];
            int compId = componentId[station];

            if(type==2){
                mpp.get(compId).remove(station);
                isOnline.remove(station);
                continue;
            }

            // type - 1
            if(isOnline.contains(station)) {
                res.add(station);
            }else{
                if(!mpp.get(compId).isEmpty()) {
                    res.add(mpp.get(compId).first());
                }else{
                    res.add(-1);
                }
            }
        }

        int[] ans = new int[res.size()];
        for(int i=0;i<ans.length;i++) ans[i] = res.get(i);
        return ans;
    }
}