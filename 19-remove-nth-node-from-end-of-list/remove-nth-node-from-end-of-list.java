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
        int count=0;
        ListNode cur=head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        int val=count;
        count=0;
        if(val==1) return null;
        if(val==2){ 
            if(n==1){
                head.next=null;
                return head;
            }
            else{
                head=head.next;
                return head;
            }
        } 
        ListNode ptr=null;
        cur=head;
        while(count<val-n){
            ptr=cur;
            count++;
            cur=cur.next;
        }
        if(ptr==null) return head.next;
        ptr.next=cur.next;
        return head;
    }
}