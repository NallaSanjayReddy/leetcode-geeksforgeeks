class Solution {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long prev[]=new long[n];
        long suf[] = new long[n];
        for(int i = 1;i<n;i++)
            prev[i]=prev[i-1]+grid[0][i];
        for(int i =n-2;i>=0;i--)
            suf[i]=grid[1][i]+suf[i+1];
        long ans=Math.min(prev[n-1],suf[0]);
        for(int i=1;i<n-1;i++){
            long cur=Math.max(prev[n-1]-prev[i],suf[0]-suf[i]);
            if(cur>0)
            ans=Math.min(ans,cur);
        }
        return ans;
    }
}