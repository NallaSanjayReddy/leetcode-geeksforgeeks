class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int prev=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(max<prices[i]-prev){
                max=prices[i]-prev;
            }
            if(prices[i]<prev) prev=prices[i];
        }
        return max;
    }
}