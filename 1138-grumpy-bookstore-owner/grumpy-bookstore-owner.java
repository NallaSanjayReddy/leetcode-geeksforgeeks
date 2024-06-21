class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[][] dp = new int[customers.length][2];
        for (int[] ele : dp) {
            Arrays.fill(ele, -1);
        }
        return findit(customers, grumpy, minutes, dp, 0, 0);
    }

    public int findit(int[] customers, int[] grumpy, int minutes, int[][] dp, int i, int used) {
        if (i < customers.length) {
            if (dp[i][used] == -1) {
                if (used == 0) {
                    dp[i][0] = Math.max(findit(customers, grumpy, minutes, dp, i + 1, 0)
                            + ((grumpy[i] == 0) ? customers[i] : 0),
                            sum(customers, i, i + minutes - 1) + findit(customers, grumpy, minutes, dp, i + minutes, 1));
                } else {
                    dp[i][1] = findit(customers, grumpy, minutes, dp, i + 1, 1)
                            + ((grumpy[i] == 0) ? customers[i] : 0);
                }
            }
            return dp[i][used];
        }
        return 0;
    }

    public int sum(int[] customers, int i, int j) {
        int val = 0;
        for (int k = i; k <= Math.min(j, customers.length - 1); k++) {
            val += customers[k];
        }
        return val;
    }
}
