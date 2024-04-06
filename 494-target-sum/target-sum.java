class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findit(nums,target,0,0);
    }
    public int findit(int[] nums,int target,int i, int sum){
        if(i==nums.length && sum==target){
            return 1;
        }
        else if(i<nums.length){
            return findit(nums,target,i+1,sum-nums[i])+findit(nums,target,i+1,sum+nums[i]);
        }
        return 0;
    }
}