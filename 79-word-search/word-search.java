class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(findit(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findit(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if(index == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) return false;

        visited[i][j] = true; // mark as visited

        boolean exists = findit(board, word, index + 1, i + 1, j, visited)
                      || findit(board, word, index + 1, i - 1, j, visited)
                      || findit(board, word, index + 1, i, j + 1, visited)
                      || findit(board, word, index + 1, i, j - 1, visited);

        visited[i][j] = false; // unmark as visited
        return exists;
    }
}
