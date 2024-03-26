class Pair{
    int row;
    int col;
    int dist;
    Pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}//Pair



class Solution {
    int minm=Integer.MAX_VALUE;

    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean visited[][]=new boolean [grid.length][grid[0].length];

        if(grid[0][0]==1)
                   return -1;
        // dfs(0,0,grid,1,visited);
        // return (minm!=Integer.MAX_VALUE)?minm:-1;
        return bfs(grid);
    }

    void dfs(int i,int j,int[][] grid,int steps,boolean[][] visited){
           if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j]==true || grid[i][j]==1)
                   return;


       if(i==grid.length-1 && j==grid[0].length-1)
       {
           if(grid[i][j]!=1)
                     minm=Math.min(minm,steps);
           return;
       }
    visited[i][j]=true;
    dfs(i+1,j,grid,steps+1,visited);
    dfs(i-1,j,grid,steps+1,visited);
    dfs(i,j+1,grid,steps+1,visited);
    dfs(i,j-1,grid,steps+1,visited);
    dfs(i-1,j-1,grid,steps+1,visited);
    dfs(i-1,j+1,grid,steps+1,visited);
    dfs(i+1,j+1,grid,steps+1,visited);
    dfs(i+1,j-1,grid,steps+1,visited);
    visited[i][j]=false;
    }



    int bfs(int[][] grid){
        
        int RowDir[]={-1,-1,0,1,1,1,0,-1};
        int ColDir[]={0,1,1,1,0,-1,-1,-1};
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        Queue<Pair> q=new LinkedList<>();
        
        if(grid[0][0]==1)
                  return -1;
        
        q.add(new Pair(0,0,1));
        
        int Ans=Integer.MAX_VALUE;

        while(!q.isEmpty()){
             Pair rem=q.poll();
             if(rem.row==m-1 && rem.col==n-1){
                    Ans=rem.dist;
                    break;
             }


             for(int i=0;i<8;i++){
               int c_row=RowDir[i]+rem.row;
               int c_col=ColDir[i]+rem.col;
               if(c_row>=0 && c_row<m && c_col>=0 && c_col<n && visited[c_row][c_col]==false && grid[c_row][c_col]!=1){
                   q.add(new Pair(c_row,c_col,rem.dist+1));
                   visited[c_row][c_col]=true;
               }
             }//8 directions ....
        }//q
         return (Ans==Integer.MAX_VALUE)?-1:Ans;
    }//bfs...
}