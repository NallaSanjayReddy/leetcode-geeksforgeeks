class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int[] ans={-1,-1};
        if(nums.length==0) return ans;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>target) right=mid-1;
            else if(nums[mid]<target) left=mid+1;
            else{
                int k=mid;
                int l=mid;
                while(k>=0 && nums[k]==target){
                    k--;
                }
                ans[0]=k+1;
                while(l<nums.length && nums[l]==target){
                    l++;
                }
                ans[1]=l-1;
                return ans;
            }
        }
        return ans;
    }
}