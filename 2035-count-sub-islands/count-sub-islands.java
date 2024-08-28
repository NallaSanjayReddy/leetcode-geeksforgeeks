class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    if (findIsland(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean findIsland(int[][] grid1, int[][] grid2, int i, int j) {
        if (i >= 0 && i < grid2.length && j >= 0 && j < grid2[0].length && grid2[i][j] == 1) {
            if (grid1[i][j] == 0) return false;
            grid2[i][j] = 0;
            return 
                findIsland(grid1, grid2, i, j + 1) & findIsland(grid1, grid2, i, j - 1) &
                findIsland(grid1, grid2, i + 1, j) &
                findIsland(grid1, grid2, i - 1, j);
        }
        return true;
    }
}
