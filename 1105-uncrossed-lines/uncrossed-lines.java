class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // make array elements -1
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(nums1, nums2, 0, 0, dp);
    }

    public int helper(int[] nums1, int[] nums2, int i, int j, int[][] dp) {
        // base case
        if (i == nums1.length || j == nums2.length) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (nums1[i] == nums2[j]) { 
            return dp[i][j] = 1 + helper(nums1, nums2, i + 1, j + 1, dp);
        }
        return dp[i][j] = Math.max(helper(nums1, nums2, i + 1, j, dp), helper(nums1, nums2, i, j + 1, dp));
    }
}