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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null) return head;
        ListNode dummy=new ListNode(0);
        ListNode temp=head;
        dummy.next=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        if(k>=count){
            k=k%count;
        }
        if(count==1 || k==0) return head;
        temp=head;
        ListNode prev=dummy;
        int pos=0;
        while(pos!=(count-k)){
            prev=temp;
            temp=temp.next;
            pos++;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        dummy.next=prev.next;
        prev.next=null;
        return dummy.next;
    }
    
}