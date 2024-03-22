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
    public boolean isPalindrome(ListNode head) {
        ListNode ptr=head;
        StringBuilder str=new StringBuilder();
        while(ptr!=null){
            str.append(ptr.val);
            ptr=ptr.next;
        }
        String s1=str.toString();
        str=str.reverse();
        System.out.println(str);
        String s2=str.toString();
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }
}