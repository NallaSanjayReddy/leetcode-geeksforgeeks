class Solution {
    public int minSteps(int n) {
        int dp[][]=new int[n+1][n+1];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        if(n==1) return 0;
        return 1+findit(n,dp,1,1,1);
    }
    public int findit(int n, int[][] dp, int str, int cpy, int val){
        if(str==n && val<=n) return 0; // check the base case correctly
        if(str<n && val<n){
            if(dp[str][cpy]==-1){
                int val1=findit(n,dp,str+cpy,cpy,val+1); // pass val as a parameter
                int val2=findit(n,dp,str,str,val+1); // pass val as a parameter
                dp[str][cpy]=1+Math.min(val1,val2);
            }
            return dp[str][cpy];
        }
        return n+1; // return a large enough value
    }
}