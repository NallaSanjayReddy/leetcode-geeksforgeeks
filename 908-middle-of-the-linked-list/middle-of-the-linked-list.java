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
    public ListNode middleNode(ListNode head) {
        ListNode ptr=head;
        int count=1;
        while(ptr!=null){
            ptr=ptr.next;
            count++;
        }
        System.out.println(count);
        int val=(count+1)/2;
        ptr=head;
        count=1;
        while(val!=count){
            ptr=ptr.next;
            count++;
        }
        return ptr;
    }
}