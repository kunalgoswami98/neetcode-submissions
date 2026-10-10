/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node temp = head;

        while(temp != null){
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        Node current = head;
        while(current != null){
            if(current.random != null) current.next.random = current.random.next;
            current = current.next.next;
        }

        Node copyNodes = new Node(0);
        Node copyTemp = copyNodes;
        current = head;
        while(current != null && current.next != null){
            copyTemp.next = current.next;
            current.next = current.next.next;
            copyTemp = copyTemp.next;
            current = current.next;
        }
        return copyNodes.next;
    }
}
