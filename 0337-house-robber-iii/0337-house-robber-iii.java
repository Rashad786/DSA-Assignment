class Pair{
    TreeNode root;
    boolean incl;
    public Pair(TreeNode root, boolean incl) {
        this.root=root;
        this.incl=incl;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return incl == pair.incl && root == pair.root;
    }

    @Override
    public int hashCode() {
        return Objects.hash(root, incl);
    }
}
class Solution {
    Map<Pair, Integer> mpp;
    public int solve(TreeNode root, boolean incl) {
        if(root==null) return 0;

        Pair pair = new Pair(root, incl);
        if(mpp.containsKey(pair)) return mpp.get(pair);

        int ans;
        if(incl) {
            ans = root.val + solve(root.left, false) + solve(root.right, false);
        }
        else {
            ans = Math.max(solve(root.left, true), solve(root.left, false)) 
                + Math.max(solve(root.right, true), solve(root.right, false));
        }
        
        mpp.put(pair, ans);
        return ans;
    }
    public int rob(TreeNode root) {
        mpp = new HashMap<>();
        return Math.max(solve(root, false), solve(root, true));
    }
}