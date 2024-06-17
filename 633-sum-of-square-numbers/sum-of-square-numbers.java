class Solution {
    public boolean judgeSquareSum(int c) {
        for(int i=0;i<=Math.ceil(Math.sqrt(c/2));i++){
            if(Math.ceil(Math.sqrt((c-Math.pow(i,2))))==Math.floor(Math.sqrt((c-Math.pow(i,2))))) return true;
        }
        return false;
    }
}