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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxSum = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return maxSum;
    }
    private int findMaxPathSum(TreeNode root) {
        if(root == null) return 0;

        int left = findMaxPathSum(root.left);
        int right = findMaxPathSum(root.right);
        int max = Math.max(left+right+root.val, Math.max(left+root.val,Math.max(right+root.val,root.val)));
        maxSum = Math.max(maxSum,max);
        return Math.max(left+root.val,Math.max(right+root.val,root.val));
    }
}
