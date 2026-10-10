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
        int length = lists.length;
        if(length == 0) return null;

        return mergeLists(lists, 0, length-1);
    }
    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if(start == end) return lists[start];
        int mid = start + (end-start)/2;
        System.out.println(mid);
        ListNode l1 = mergeLists(lists,start,mid);
        ListNode l2 = mergeLists(lists,mid+1,end);
        return merge(l1,l2);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val <= l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else{
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}