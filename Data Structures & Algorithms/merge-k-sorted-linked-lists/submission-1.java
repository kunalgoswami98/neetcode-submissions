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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergeLists(lists, 0, lists.length-1);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if(start == end) return lists[start];

        int mid = start + (end - start) / 2;
        ListNode l1 = mergeLists(lists, start, mid);
        ListNode l2 = mergeLists(lists, mid+1, end);

        return merge(l1,l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(-1);
        ListNode temp = l;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val){
                ListNode newList = new ListNode(l1.val);
                temp.next = newList;
                l1 = l1.next;
            }
            else {
                ListNode newList = new ListNode(l2.val);
                temp.next = newList;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        while(l1 != null){
            ListNode newList = new ListNode(l1.val);
            temp.next = newList;
            l1 = l1.next;
            temp = temp.next;
        }
        while(l2 != null){
            ListNode newList = new ListNode(l2.val);
            temp.next = newList;
            l2 = l2.next;
            temp = temp.next;
        }
        return l.next;
    }
}
