class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(mid<nums.length-1 && nums[mid]<target && nums[mid+1]>target) return mid+1;
            else if(mid>=1 && nums[mid]>target && nums[mid-1]<target) return mid;
            else if(mid==0 && nums[mid]>target) return 0;
            else if(mid==nums.length-1 && nums[mid]<target) return mid+1;
            else if(nums[mid]<target) left=mid+1;
            else if(nums[mid]>target) right=mid-1;
            else return mid;
        }
        return mid;
    }
}