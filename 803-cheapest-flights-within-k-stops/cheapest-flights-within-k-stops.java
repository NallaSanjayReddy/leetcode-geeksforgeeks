class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][][] dp=new int[n][n][k+1];
        HashMap<Integer,HashMap<Integer,Integer>> hash=new HashMap<>();
        for(int[] ele:flights){
            if(!hash.containsKey(ele[0])){
                hash.put(ele[0],new HashMap<>());
            }
            hash.get(ele[0]).put(ele[1],ele[2]);
        }
        for(int[][] ele:dp){
            for(int[] etr:ele){
                Arrays.fill(etr,-1);
            }
        }
        int val=findit(flights,dp,hash,src,dst,k);
        System.out.println(hash);
        // check if the final value is equal to 1000001 and return -1 instead
        if(val>=1000001) return -1;
        else return val;
    }
    public int findit(int[][] flights, int[][][] dp, HashMap<Integer,HashMap<Integer,Integer>> hash, int src, int dst, int k){
        // check if the hash map contains the source city before iterating over the entry set
        if(k>=0 && src!=dst && hash.containsKey(src)){
            if(dp[src][dst][k]==-1){
                dp[src][dst][k]=1000001;
                // iterate only over the adjacent cities and their costs for the source city
                for(Map.Entry<Integer,Integer> etr:hash.get(src).entrySet()){
                    if(etr.getKey()==dst) dp[src][dst][k]=Math.min(dp[src][dst][k],etr.getValue()+findit(flights,dp,hash,etr.getKey(),dst,k));
                    else dp[src][dst][k]=Math.min(dp[src][dst][k],etr.getValue()+findit(flights,dp,hash,etr.getKey(),dst,k-1));
                }
            }
            return dp[src][dst][k];
        }
        else if(src==dst && k>=0) return 0;
        return 1000001;
    }
}
