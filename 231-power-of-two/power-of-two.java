class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<0) return false;
        if(n==0) return false;
        if(n==1) return true;
        for(int i=3;i<=n;i+=2){
            if((n&i)!=0) return false;
        }
        return true;
    }
}