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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode first=dummy;
        ListNode second=dummy;
        while(n>0){
            second=second.next;
            n-=1;
        }
        while(second.next!=null){
            second=second.next;
            first=first.next;
        }
        System.out.println(first.val);
        first.next=first.next.next;
        return dummy.next;
    }
}