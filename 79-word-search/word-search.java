class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    StringBuilder str = new StringBuilder();
                    ans = findit(board, word, 0, i, j, str, visited);
                    if (ans) {
                        return true;
                    }
                }
            }
        }
        return ans;
    }

    public boolean findit(char[][] board, String word, int k, int i, int j, StringBuilder str, boolean[][] visited) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }
        visited[i][j] = true;
        str.append(board[i][j]);
        boolean ans = findit(board, word, k + 1, i - 1, j, new StringBuilder(str), visited) ||
                      findit(board, word, k + 1, i + 1, j, new StringBuilder(str), visited) ||
                      findit(board, word, k + 1, i, j - 1, new StringBuilder(str), visited) ||
                      findit(board, word, k + 1, i, j + 1, new StringBuilder(str), visited);
        visited[i][j] = false; // backtrack
        return ans;
    }
}
