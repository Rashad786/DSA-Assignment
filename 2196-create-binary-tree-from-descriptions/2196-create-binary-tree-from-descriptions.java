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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> mpp = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for(int[]row: descriptions) {
            int parent = row[0];
            int child = row[1];
            int isLeft = row[2];

            if(!mpp.containsKey(parent)) mpp.put(parent, new TreeNode(parent));
            if(!mpp.containsKey(child)) mpp.put(child, new TreeNode(child));

            TreeNode par = mpp.get(parent);
            TreeNode chi = mpp.get(child);
            if(isLeft==1) par.left = chi;
            else par.right = chi;
            children.add(child);
        }
        for(int[]row: descriptions) {
            if(!children.contains(row[0])) return mpp.get(row[0]);
        }
        return null;
    }
}