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
    int inorderIndex;
    int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndex = 0;
        preorderIndex = 0;

        return built(preorder,inorder,Integer.MAX_VALUE);
    }
    private TreeNode built(int[] preorder, int[] inorder, int limit){
        if(preorderIndex >= preorder.length) return null;

        if(inorder[inorderIndex] == limit){
            inorderIndex++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[preorderIndex++]);
        node.left = built(preorder,inorder,node.val);
        node.right = built(preorder,inorder,limit);
        return node;
    }
}
