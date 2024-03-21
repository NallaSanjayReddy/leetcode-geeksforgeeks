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
        if(head==null) return head;
        ListNode prev=null;
        ListNode ptr=head;
        if(head.next==null) return head;
        ListNode ptr2=head.next;
        while(ptr2!=null){
            ptr.next=prev;
            prev=ptr;
            ptr=ptr2;
            ptr2=ptr.next;
        }
        ptr.next=prev;
        return ptr;
    }
}