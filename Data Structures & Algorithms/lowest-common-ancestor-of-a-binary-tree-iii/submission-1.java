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

        Node pt1 = p;
        Node pt2 = q;
        while(pt1 != pt2){
            pt1 = (pt1 != null) ? pt1.parent : q;
            pt2 = (pt2 != null) ? pt2.parent : p;
        }
        return pt1;
    }
}