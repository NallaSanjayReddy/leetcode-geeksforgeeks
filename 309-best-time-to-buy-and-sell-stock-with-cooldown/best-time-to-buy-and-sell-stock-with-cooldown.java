class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int[][] dp = new int[prices.length][3];
        for(int[] ele : dp){
            Arrays.fill(ele, Integer.MIN_VALUE);
        }
        return findit(prices, dp, 0, 0);
    }        
    int findit(int[] prices, int[][] dp, int i, int state){
        if(i >= prices.length) return 0;
        if(dp[i][state] != Integer.MIN_VALUE){
            return dp[i][state];
        }
        int doNothing = findit(prices, dp, i + 1, state == 2 ? 0 : state);
        int buy = 0, sell = 0;
        if(state == 0){
            // Buy stock
            buy = findit(prices, dp, i + 1, 1) - prices[i];
        } else if(state == 1){
            // Sell stock and enter cooldown
            sell = prices[i] + findit(prices, dp, i + 1, 2);
        }
        dp[i][state] = Math.max(doNothing, Math.max(buy, sell));
        return dp[i][state];
    }
}
