class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans=new int[rowSum.length][colSum.length];
        for(int i=0;i<rowSum.length;i++){
            for(int j=0;j<colSum.length;j++){
                ans[i][j]=Math.min(rowSum[i],colSum[j]);
                if(Math.min(rowSum[i],colSum[j])==rowSum[i]){
                    colSum[j]-=rowSum[i];
                    rowSum[i]=0;
                }
                else{
                    rowSum[i]-=colSum[j];
                    colSum[j]=0;
                }
            }
        }
        return ans;
    }
}