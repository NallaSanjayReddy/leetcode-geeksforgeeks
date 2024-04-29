class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return findit(triangle, dp, 0, 0);
    }
    int findit(List<List<Integer>> triangle, int[][] dp, int i, int j){
        if(i<triangle.size()){
            if(dp[i][j]==-1){
                dp[i][j]= triangle.get(i).get(j) + Math.min(findit(triangle,dp,i+1,j),findit(triangle,dp,i+1,j+1));
            }
            return dp[i][j];
        }
        return 0;
    }
}