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
    public ListNode removeZeroSumSublists(ListNode head) {
        int prefixSum=0;
        HashMap<Integer,ListNode> hash=new HashMap<>();
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        hash.put(0,dummy);
        while(head!=null){
            prefixSum+=head.val;
            if(hash.containsKey(prefixSum)){
                ListNode start=hash.get(prefixSum);
                ListNode temp=start.next;
                int sum=prefixSum;
                while(temp!=head){
                    sum+=temp.val;
                    hash.remove(sum);
                    temp=temp.next;
                }
                start.next=head.next;
            }
            else{
                hash.put(prefixSum,head);
            }
            head=head.next;
        }
        System.out.println(hash);
        return dummy.next;
    }
}