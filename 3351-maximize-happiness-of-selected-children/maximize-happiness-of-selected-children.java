class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long val=0;
        int j=0;
        for(int i=happiness.length-1;i>=0 && k>0;i--){
            if((happiness[i]-j)>0){ 
                val+=(happiness[i]-j);
                j++;
                k--;
            }
            else break;
        }
        return val;
    }
}