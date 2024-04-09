class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int sum=0;
        int val=tickets[k];
        for(int i=0;i<tickets.length;i++){
            if(i<=k) sum+=Math.min(val,tickets[i]);
            else sum+=Math.min(val-1,tickets[i]);
        }
        return sum;
    }
}