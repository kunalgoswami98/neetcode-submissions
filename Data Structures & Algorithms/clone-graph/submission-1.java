/*
Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> visited = new HashMap<>();
        return cloneGraphDFS(node, visited);
    }

    private Node cloneGraphDFS(Node node, HashMap<Node, Node> visited){
        if(visited.containsKey(node)) return visited.get(node);
        Node root = new Node(node.val);
        visited.put(node, root);
        List<Node> neighbors = node.neighbors;
        for(Node neighbor: neighbors) {
                root.neighbors.add(cloneGraphDFS(neighbor, visited));
        }
        return root;
    }
}