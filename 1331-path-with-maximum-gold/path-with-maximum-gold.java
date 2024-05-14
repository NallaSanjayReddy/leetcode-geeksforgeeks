class Solution {
    public int getMaximumGold(int[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        for(int[] ele:visited){
            Arrays.fill(ele,-1);
        }
        return findit(grid,visited);
    }
    public int findit(int[][] grid, int[][] visited){
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    max=Math.max(max,dfs(grid,visited,i,j,0));
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid, int[][] visited, int i, int j, int sum){
        visited[i][j]=1;
        int max=sum+grid[i][j];
        if(i<grid.length-1 && visited[i+1][j]==-1 && grid[i+1][j]!=0) max=Math.max(max,dfs(grid,visited,i+1,j,sum+grid[i][j]));
        if(j<grid[0].length-1 && visited[i][j+1]==-1 && grid[i][j+1]!=0) max=Math.max(max,dfs(grid,visited,i,j+1,sum+grid[i][j]));
        if(i>0 && visited[i-1][j]==-1 && grid[i-1][j]!=0) max=Math.max(max,dfs(grid,visited,i-1,j,sum+grid[i][j]));
        if(j>0 && visited[i][j-1]==-1 && grid[i][j-1]!=0) max=Math.max(max,dfs(grid,visited,i,j-1,sum+grid[i][j]));
        visited[i][j]=-1;
        return max;
    }
}