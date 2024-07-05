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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        TreeSet<Integer> list=new TreeSet<>((a,b)->(a-b));
        ListNode ptr=head;
        int i=0;
        int prev=-1;
        while(ptr!=null){
            if(prev!=-1 && ptr.next!=null){
                if(ptr.val<ptr.next.val && ptr.val<prev){
                    list.add(i);
                }
                if(ptr.val>ptr.next.val && ptr.val>prev){
                    list.add(i);
                }
            }
            i++;
            prev=ptr.val;
            ptr=ptr.next;
        }
        if(list.size()<2) return new int[]{-1,-1};
        int min=Integer.MAX_VALUE;
        int max=list.last()-list.first();
        prev=-1;
        for(int ele:list){
            if(prev!=-1){
                min=Math.min(min,ele-prev);
            }
            prev=ele;
        }
        return new int[]{min,max};
    }
}