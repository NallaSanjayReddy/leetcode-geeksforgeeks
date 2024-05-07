class Solution {
    public ListNode doubleIt(ListNode head) {
        if (head == null) return null;
        
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
        ptr = new ListNode(ans.charAt(ans.length()-1)-'0');
        dummy.next=ptr;
        for (int i = ans.length() - 2; i >= 0; i--) {
            ptr.next = new ListNode(ans.charAt(i) - '0');
            ptr = ptr.next;
        }
        
        return dummy.next;
    }
}
