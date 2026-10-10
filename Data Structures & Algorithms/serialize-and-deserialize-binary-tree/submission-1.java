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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder strBuild = new StringBuilder();
        encode(root, strBuild);
        return strBuild.toString();
    }

    private void encode(TreeNode root, StringBuilder strBuild){
        if(root == null){
            strBuild.append("*").append(",");
            return;
        }
        strBuild.append(root.val).append(",");
        encode(root.left, strBuild);
        encode(root.right, strBuild);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return decode(queue);
    }
    private TreeNode decode(Queue<String> queue){
        if(queue.isEmpty()) return null;
        String value = queue.poll();
        if(value.equals("*")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = decode(queue);
        root.right = decode(queue);
        return root;
    }
}
