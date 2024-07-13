class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findit(nums, dp, 0, -1);
    }

    public int findit(int[] nums, int[][] dp, int i, int prevIndex) {
        if (i == nums.length) {
            return 0;
        }
        if (dp[i][prevIndex + 1] != -1) {
            return dp[i][prevIndex + 1];
        }
        int notTake = findit(nums, dp, i + 1, prevIndex);
        int take = 0;
        if (prevIndex == -1 || nums[i] > nums[prevIndex]) {
            take = 1 + findit(nums, dp, i + 1, i);
        }
        dp[i][prevIndex + 1] = Math.max(take, notTake);
        return dp[i][prevIndex + 1];
    }
}
