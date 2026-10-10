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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode tempPoint1 = list1;
        ListNode tempPoint2 = list2;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(tempPoint1 != null && tempPoint2 != null){
            if(tempPoint1.val <= tempPoint2.val){
                temp.next = new ListNode(tempPoint1.val);
                tempPoint1 = tempPoint1.next;
            }
            else{
                temp.next = new ListNode(tempPoint2.val);
                tempPoint2 = tempPoint2.next;
            }
            temp = temp.next;
        }
        while(tempPoint1 != null){
            temp.next = new ListNode(tempPoint1.val);
            tempPoint1 = tempPoint1.next;
            temp = temp.next;
        }
        while(tempPoint2 != null){
            temp.next = new ListNode(tempPoint2.val);
            temp = temp.next;
            tempPoint2 = tempPoint2.next;
        }
        return result.next;
    }
}