class Solution {

    public long find ( int i , int[][] arr,Long[] dp ) { 

        if( i>=arr.length ) return 0 ; 
        if( dp[i] != null ) return dp[i];

        long take = find( i+arr[i][1]+1,arr,dp  ) + arr[i][0] ;
        long ntake = find( i+1,arr,dp ) ;

        return dp[i]=Math.max(take,ntake);

    } 
    public long mostPoints(int[][] questions) {

        Long[] dp = new Long[questions.length];
        return find( 0,questions,dp );
    }
}