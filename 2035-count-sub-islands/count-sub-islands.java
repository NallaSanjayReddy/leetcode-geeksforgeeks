class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid2.length;
        int n = grid2[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) {
            return true; // Out of bounds or water cell
        }

        if (grid1[i][j] == 0) {
            return false; // Mismatched cell
        }

        grid2[i][j] = 0; // Mark cell as visited

        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);

        return up && down && left && right;
    }
}
