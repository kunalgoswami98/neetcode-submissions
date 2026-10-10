/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode previous = null;
        ListNode current = head;
        ListNode ahead = head.next;

        while(current != null){
            current.next = previous;
            previous = current;
            current = ahead;
            if(ahead != null) ahead = ahead.next;
        }
        return previous;
    }
}
