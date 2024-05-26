class Solution {
    public void solve(char[][] board) {
        boolean visited[][]=new boolean [board.length][board[0].length];
        if(board.length<=2 || board[0].length<=2) return;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O' && (i==0 || j==0 || i==board.length-1 || j==board[0].length-1)){
                    findit(board, visited, i, j);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='L'){
                    board[i][j]='O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }
    }
    public void findit(char[][] board, boolean[][] visited, int i, int j){
        if(visited[i][j]==false){    
            visited[i][j]=true;
            board[i][j]='L';
            if(i+1<board.length && board[i+1][j]=='O') findit(board,visited,i+1,j);
            if(j+1<board[0].length && board[i][j+1]=='O') findit(board,visited,i,j+1);
            if(i-1>=0 && board[i-1][j]=='O') findit(board,visited,i-1,j);
            if(j-1>=0 && board[i][j-1]=='O') findit(board,visited,i,j-1);
        }
    }
}