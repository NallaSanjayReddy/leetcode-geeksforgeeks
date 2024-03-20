class Solution {
    public int rob(int[] nums) {
        int[][] dp=new int[nums.length][2];
        for(int[] ele:dp){
            ele[0]=-1;
            ele[1]=-1;
        }
        return findit(nums,dp,0,0);
    }
    public int findit(int[] nums, int[][] dp, int i, int flag){
        if(i<nums.length){
            if(dp[i][flag]==-1){
                if(flag==0) dp[i][flag]=Math.max(findit(nums,dp,i+1,0),nums[i]+findit(nums,dp,i+1,1));
                else{
                    dp[i][flag]=findit(nums,dp,i+1,0);
                }
            }   
            return dp[i][flag];
        }
        return 0;
    }
}
