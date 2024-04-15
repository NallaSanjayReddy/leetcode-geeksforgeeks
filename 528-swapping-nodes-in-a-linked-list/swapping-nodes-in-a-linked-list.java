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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode ptr1=head;
        int count=1;
        while(count<k){
            ptr1=ptr1.next;
            count++;
        }
        ListNode ptr=head;
        count=0;
        while(ptr!=null){
            ptr=ptr.next;
            count++;
        }
        ListNode ptr2=head;
        int count2=1;
        while(count2<(count-(k-1))){
            ptr2=ptr2.next;
            count2++;
        }
        int temp=ptr1.val;
        ptr1.val=ptr2.val;
        ptr2.val=temp;
        return dummy.next;
    }
}