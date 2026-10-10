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
    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        findLCA(root, p, q);
        return lca;
    }

    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;

        //check childs
        boolean left = findLCA(root.left, p, q);
        boolean right = findLCA(root.right, p, q);

        //if current node is lca
        if((left && right) || ((left || right) && (root.val == p.val || root.val == q.val))){
            lca = root;
        }

        return left || right || root.val == p.val || root.val == q.val;
    }
}
