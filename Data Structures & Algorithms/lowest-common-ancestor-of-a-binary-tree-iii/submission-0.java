/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        if(p == null || q == null) return null;
        if(p == q) return p;
        Set<Node> set = new HashSet<>();
        return findLCA(p,q, set);
    }

    private Node findLCA(Node p, Node q, Set<Node> set){
        if(p != null && set.contains(p)) return p;
        if(q != null && set.contains(q)) return q;
        if(p == q) return p;

        if(p != null){
            set.add(p);
            return findLCA(p.parent, q, set);
        }
        if(q != null){
            set.add(q);
            return findLCA(p, q.parent, set);
        }
        return null;
    }
}