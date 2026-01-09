/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxDepth;
    public void findDeepest(TreeNode root, int d, Map<Integer, Integer> mpp) {
        if(root==null) return;

        maxDepth = Math.max(maxDepth, d);
        mpp.put(root.val, d);
        findDeepest(root.left, d+1, mpp);
        findDeepest(root.right, d+1, mpp);
    }
    public TreeNode solve(TreeNode root, int maxDepth, Map<Integer, Integer> mpp) {
        if(root==null || mpp.get(root.val)==maxDepth) return root;

        TreeNode left = solve(root.left, maxDepth, mpp);
        TreeNode right = solve(root.right, maxDepth, mpp);

        if(left!=null && right!=null) return root;

        return left!=null ? left : right;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        maxDepth = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        findDeepest(root, 0, mpp);
        return solve(root, maxDepth, mpp);
    }
}