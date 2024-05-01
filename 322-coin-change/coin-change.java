class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);
        Arrays.sort(coins);
        int val=findit(coins,dp,amount);
        if(val==Integer.MAX_VALUE) return -1;
        else return val;
    }
    public int findit(int[] coins,int[] dp,int amount){
        if(amount>0){
            if(dp[amount]==-1){
                dp[amount]=Integer.MAX_VALUE;
                int i=0;
                while(i<coins.length && coins[i]<=amount){ 
                    int val=findit(coins,dp,amount-coins[i]);
                    if(val!=Integer.MAX_VALUE) dp[amount]=Math.min(dp[amount],1+val);
                    i++;
                }
            }
            return dp[amount];
        }
        return 0;
    }
}