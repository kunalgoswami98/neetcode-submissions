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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode sumNode = new ListNode(0);
        ListNode current = sumNode;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int remainder = 0;

        while(temp1 != null && temp2 != null){
            int sum = temp1.val + temp2.val + remainder;
            remainder = sum / 10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            current.next = newNode;
            current = current.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1 != null){
            int sum = temp1.val + remainder;
            remainder = sum / 10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            current.next = newNode;
            current = current.next;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            int sum = temp2.val + remainder;
            remainder = sum / 10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            current.next = newNode;
            current = current.next;
            temp2 = temp2.next;
        }
        if(remainder > 0){
            ListNode newNode = new ListNode(1);
            current.next = newNode;
            current = current.next;
        }
        return  sumNode.next;
    }
}
