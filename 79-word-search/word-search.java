class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    StringBuilder str = new StringBuilder();
                    ans |= findit(board, word, 0, i, j, str, visited);
                    if (ans) {
                        return true;
                    }
                }
            }
        }
        return ans;
    }

    public boolean findit(char[][] board, String word, int k, int i, int j, StringBuilder str, boolean[][] visited) {
        if (visited[i][j]) return false;
        str.append(board[i][j]);
        if (k == word.length() - 1) {
            if (str.toString().equals(word)) return true;
            str.deleteCharAt(str.length() - 1); // backtrack
            return false;
        }
        visited[i][j] = true;
        boolean ans = false;
        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, -1, 1};
        for (int d = 0; d < 4; d++) {
            int newRow = i + rows[d];
            int newCol = j + cols[d];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                if (word.charAt(k + 1) == board[newRow][newCol]) {
                    ans |= findit(board, word, k + 1, newRow, newCol, new StringBuilder(str), visited);
                    if (ans) break; // stop if one valid path is found
                }
            }
        }
        visited[i][j] = false; // backtrack
        str.deleteCharAt(str.length() - 1); // backtrack
        return ans;
    }
}
