class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode ptr = head;
        StringBuilder sum = new StringBuilder();
        while (ptr != null) {
            sum.append(ptr.val);
            ptr = ptr.next;
        }
        
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = sum.length() - 1; i >= 0; i--) {
            int val = (sum.charAt(i) - '0') * 2 + carry;
            ans.append(val % 10);
            carry = val / 10;
        }
        if (carry != 0) ans.append(carry);
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i = ans.length() - 1; i >= 0; i--) {
            current.next = new ListNode(ans.charAt(i) - '0');
            current = current.next;
        }
        
        return dummy.next;
    }
}
