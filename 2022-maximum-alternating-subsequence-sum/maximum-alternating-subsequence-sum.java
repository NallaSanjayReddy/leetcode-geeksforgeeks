class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp=new long[nums.length][2];
        for(long[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return findit(nums,dp,0,0);
    }
    public long findit(int[] nums, long[][] dp, int i, int j){
        if(i<nums.length){
            if(j%2==0){
                if(dp[i][0]==-1){
                    dp[i][0]=Math.max(nums[i]+findit(nums,dp,i+1,j+1), findit(nums,dp,i+1,j));
                }
                return dp[i][0];
            }
            else{
                if(dp[i][1]==-1){
                    dp[i][1]=Math.max(-nums[i]+findit(nums,dp,i+1,j+1), findit(nums,dp,i+1,j));
                }
                return dp[i][1];
            }
        }
        return 0;
    }
}