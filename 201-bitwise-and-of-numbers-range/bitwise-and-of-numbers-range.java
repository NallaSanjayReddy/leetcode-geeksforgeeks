class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if(left==right) return left;
        int ans=0;
        int count=0;
        while(left!=0 || right!=0){
            if(left%2==1 && right%2==1){
                ans+=Math.pow(2,count)*1;
                count++;
            }
            else if(left%2==0 && right%2==0){
                count++;
            }
            else{
                ans=0;
                count++;
            }
            left/=2;
            right/=2;
        }
        return ans;
    }
}