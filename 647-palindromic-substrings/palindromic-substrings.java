class Solution {
    public int countSubstrings(String s) {
        StringBuilder str=new StringBuilder(s).reverse();
        String s2=str.toString();
        int[][] dp=new int[s.length()][s.length()];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return findit(s,s2,dp,0,s.length()-1);
    }
    public int findit(String s,String s2, int[][] dp, int i, int j){
        if(i<=j){
            if(dp[i][j]==-1){
                if(s.substring(i,j+1).equals(s2.substring(s.length()-1-j,s.length()-i))){
                    dp[i][j]=1+findit(s,s2,dp,i+1,j)+findit(s,s2,dp,i,j-1);
                }
                else{
                    dp[i][j]=findit(s,s2,dp,i+1,j)+findit(s,s2,dp,i,j-1);
                }
                return dp[i][j];
            }
        }
        return 0;
    }
}