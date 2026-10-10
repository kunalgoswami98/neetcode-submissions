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
    int kthSmallest;
    int kth;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        kthSmallest = Integer.MAX_VALUE;
        kth = k;
        findKthSmallest(root);

        return kthSmallest;
    }
    private void findKthSmallest(TreeNode root){
        if(kth <= 0 || root == null) return;
        
        findKthSmallest(root.left);
        kth = kth - 1;
        if(kth == 0) {
            kthSmallest = kthSmallest == Integer.MAX_VALUE ? root.val : kthSmallest;
            return;
        }
        findKthSmallest(root.right);
    }
}