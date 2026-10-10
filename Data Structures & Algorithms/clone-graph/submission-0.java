/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> alreadyAddedNode;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        alreadyAddedNode = new HashMap<>();
        return cloneGraphDFS(node);
    }

    private Node cloneGraphDFS(Node node){
        if(alreadyAddedNode.containsKey(node.val)){
            return alreadyAddedNode.get(node.val);
        }

        Node root = new Node(node.val);
        alreadyAddedNode.put(node.val, root);

        List<Node> neighbors = node.neighbors;

        for(int i = 0; i < neighbors.size(); i++){
            Node neighbor = neighbors.get(i);
            
            root.neighbors.add(cloneGraphDFS(neighbor));
        }

        return root;
    }
}