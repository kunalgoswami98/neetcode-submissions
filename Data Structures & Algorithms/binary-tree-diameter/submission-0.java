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
    int maxDia;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        maxDia = 0;

        calculateDiameter(root);
        return maxDia;
    }
    private int calculateDiameter(TreeNode root) {
        if(root == null) return 0;

        int left = calculateDiameter(root.left);
        int right = calculateDiameter(root.right);

        maxDia = Math.max(maxDia, left + right);
        return 1 + Math.max(left,right);
    }
}
