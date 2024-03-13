class Solution {
    public int pivotInteger(int n) {
        if(n==1) return 1;
        int presum=1;
        int nextsum=n*(n+1)/2;
        for(int i=1;i<n;i++){
            if(presum==nextsum){
                return i;
            }
            else{
                presum+=(i+1);
                nextsum-=i;
            }
        }
        return -1;
    }
}