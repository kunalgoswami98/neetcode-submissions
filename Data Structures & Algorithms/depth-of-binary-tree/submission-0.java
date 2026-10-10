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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        maxDepth = 0;
        findMaxDepth(root,1);
        return maxDepth;
    }
    private void findMaxDepth(TreeNode root, int level){
        if(root == null) return;
        maxDepth = Math.max(level,maxDepth);
        findMaxDepth(root.left,level+1);
        findMaxDepth(root.right,level+1);
    }
}
