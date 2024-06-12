class Solution {
    public void sortColors(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<nums.length && nums[left]==0){
            left++;
        }
        while(right>=0 && nums[right]==2){
            right--;
        }
        int i=left;
        while(i<=right){
            if(nums[i]==0){
                nums[i]=nums[left];
                nums[left]=0;
                left++;
                while(left<nums.length && nums[left]==0){
                    left++;
                }
                i=left;
            }
            else if(nums[i]==2){
                nums[i]=nums[right];
                nums[right]=2;
                right--;
                while(right>=0 && nums[right]==2){
                    right--;
                }
            }
            else{
                i++;
            }
        }
    }
}