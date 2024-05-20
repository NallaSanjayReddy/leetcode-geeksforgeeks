class Solution {
    public int subsetXORSum(int[] nums) {
        int ans[]={0};
        findit(nums,0,0,ans);
        return ans[0];
    }
    void findit(int[] nums, int i, int xor, int[] ans){
        if(i<nums.length){
            findit(nums,i+1,xor,ans);
            findit(nums,i+1,xor^nums[i],ans);
        }
        else{
            ans[0]+=xor;
        }
    }
}