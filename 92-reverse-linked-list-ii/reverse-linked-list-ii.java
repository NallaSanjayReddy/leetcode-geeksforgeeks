/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)//reversing the same node 
            return head;

        ListNode temp1 = head;
        ListNode temp2 = head;
        int node = 1;

        while (node != right) {
            if(node<left)
              temp1 = temp1.next;

            temp2 = temp2.next;
            node++;
        }

         
        ListNode t = head;
        ListNode temp3 = temp2.next;
        if (head == temp1) {
            head = null;
            temp2.next = null;
        }
        else {
           
            while(t.next != temp1)
               t = t.next;

            t.next = null;
            temp2.next = null;
        }
        
        //reversing the sublist
        ListNode curr = temp1;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        temp2 = temp1;
        temp1 = prev;
        

        temp2.next = temp3;
        if(head == null)
          head = temp1;
        else
           t.next  = temp1;

        return head;
    }
}