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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hash=new HashSet<>();
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        for(int ele:nums){
            hash.add(ele);
        }
        ListNode pre=dummy;
        ListNode ptr=head;
        while(ptr!=null){
            if(hash.contains(ptr.val)){
                pre.next=ptr.next;
                ptr=ptr.next;
            }
            else{
                pre=pre.next;
                ptr=ptr.next;
            }
        }
        return dummy.next;
    }
}