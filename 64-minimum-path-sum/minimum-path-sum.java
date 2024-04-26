class Solution {

    public int minPathSum(int[][] grid) {
        LinkedList<pair> list = new LinkedList<>();
        list.add(new pair(0, 0, grid[0][0]));
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] ele : dp) {
            Arrays.fill(ele, Integer.MAX_VALUE);
        }
        dp[0][0] = grid[0][0];
        
        while (!list.isEmpty()) {
            pair etr = list.poll();
            int row = etr.i;
            int col = etr.j;
            int val = etr.sum;
            
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                continue;
            }
            
            if (row < grid.length - 1) {
                int downVal = val + grid[row + 1][col];
                if (downVal < dp[row + 1][col]) {
                    dp[row + 1][col] = downVal;
                    list.add(new pair(row + 1, col, downVal));
                }
            }
            
            if (col < grid[0].length - 1) {
                int rightVal = val + grid[row][col + 1];
                if (rightVal < dp[row][col + 1]) {
                    dp[row][col + 1] = rightVal;
                    list.add(new pair(row, col + 1, rightVal));
                }
            }
        }
        
        return dp[grid.length - 1][grid[0].length - 1];
    }
}

class pair {
    int i;
    int j;
    int sum;
    pair(int x, int y, int val) {
        i = x;
        j = y;
        sum = val;
    }
}
