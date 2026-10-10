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
    int level;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        level = 0;
        List<Integer> list = new ArrayList<>();
        getRightSideView(root,1,list);
        return list;
    }
    private void getRightSideView(TreeNode root, int currentLevel, List<Integer> list){
        if(root == null) return;
        if(currentLevel > level){
            list.add(root.val);
            level = currentLevel;
        }
        getRightSideView(root.right, currentLevel+1, list);
        getRightSideView(root.left, currentLevel+1, list);
    }
}
