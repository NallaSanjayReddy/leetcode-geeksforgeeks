class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for(int target = 0; target < n + 1; target++){
            for(int s = 0; s < target; s++){
                int square = s*s;
                if(target - square < 0)
                    break;
                dp[target] = Math.min(dp[target], 1 + dp[target - square]);    
            }
        }
        return dp[n];
    }
}