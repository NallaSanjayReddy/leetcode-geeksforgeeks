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
    public ListNode mergeNodes(ListNode head) {
        ListNode ptr=head;
        ListNode ans=new ListNode(0);
        ListNode ptr2=ans;
        int sum=0;
        while(ptr!=null){
            if(ptr.val==0 && sum==0){
                ptr=ptr.next;
            }
            else if(ptr.val==0 && sum!=0){
                ptr2.next=new ListNode(sum);
                ptr2=ptr2.next;
                sum=0;
            }
            else{
                sum+=ptr.val;
                ptr=ptr.next;
            }
        }
        return ans.next;
    }
}