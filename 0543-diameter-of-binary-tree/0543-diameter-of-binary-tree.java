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
    int dia;
    public int solve(TreeNode root) {
        if(root==null) return 0;

        int lh = solve(root.left);
        int rh = solve(root.right);

        dia = Math.max(dia, lh+rh);

        return 1+Math.max(lh, rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dia=0;
        solve(root);
        return dia;
    }
}