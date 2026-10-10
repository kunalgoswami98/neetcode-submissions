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
    TreeNode lowestAncestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        findLowestCommonAncestor(root,p,q);
        return lowestAncestor;
    }
    private boolean findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;

        boolean left = findLowestCommonAncestor(root.left,p,q);
        boolean right = findLowestCommonAncestor(root.right,p,q);

        if((left && right) || ((root.val == q.val || root.val == p.val) && (left || right))){
            lowestAncestor = root;
        }
        if(p.val == root.val || q.val == root.val || left || right) return true;
        return false;
    }
}
