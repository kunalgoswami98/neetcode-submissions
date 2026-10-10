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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return countGoodNodes(root,Integer.MIN_VALUE);
    }
    private int countGoodNodes(TreeNode root, int maxValue){
        if(root == null) return 0;
        return root.val >= maxValue ? 1+ countGoodNodes(root.left, Math.max(root.val,maxValue)) + countGoodNodes(root.right, Math.max(root.val,maxValue))
        : countGoodNodes(root.left, Math.max(root.val,maxValue)) + countGoodNodes(root.right, Math.max(root.val,maxValue));
    }
}
