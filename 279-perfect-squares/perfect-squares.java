class Solution {
    public int numSquares(int n) {
        List<Integer> list=new ArrayList<Integer>(); 
        for(int i=n;i>0;i--){
            if(Math.floor(Math.sqrt(i))==Math.ceil(Math.sqrt(i))){
                list.add(i);
            }
        }
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return findit(n,dp,list);
    }
    int findit(int n, int[] dp,List<Integer> list){
        if(n==0) return 0;
        if(dp[n]==-1){
            dp[n]=10001;
            for(int i=list.size()-1; i>=0 && list.get(i)<=n;i--){
                dp[n]=Math.min(dp[n],1+findit(n-list.get(i),dp,list));
            }
        }
        return dp[n];
    }
}