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
        if(root == null) return "";
        StringBuilder serializedBuilder = new StringBuilder();
        getSerializedData(root, serializedBuilder);
        return serializedBuilder.toString();
    }

    private void getSerializedData(TreeNode root, StringBuilder serializedBuilder){
        if(root == null) {
            serializedBuilder.append('*').append(',');
            return;
        }
        serializedBuilder.append(root.val).append(',');

        getSerializedData(root.left, serializedBuilder);
        getSerializedData(root.right, serializedBuilder);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return getDeserializedData(queue);
    }
    private TreeNode getDeserializedData(Queue<String> queue) {
        if(queue.isEmpty()) return null;

        String str = queue.remove();
        if(str.equals("*")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = getDeserializedData(queue);
        root.right = getDeserializedData(queue);
        return root;
    }
}
