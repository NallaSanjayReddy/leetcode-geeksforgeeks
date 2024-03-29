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
    public int pairSum(ListNode head) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        ListNode ptr=head;
        int i=0;
        while(ptr!=null){
            hash.put(i,ptr.val);
            ptr=ptr.next;
            i++;
        }
        int max=0;
        for(Map.Entry<Integer,Integer> etr:hash.entrySet()){
            int val1=etr.getValue();
            int val2=hash.get(i-1-etr.getKey());
            if(max<val1+val2){
                max=val1+val2;
            }
        }
        return max;
    }
}