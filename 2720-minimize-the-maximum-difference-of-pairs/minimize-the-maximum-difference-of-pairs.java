class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left=0;
        int right=nums[nums.length-1]-nums[0];
        while(right>=left){
            int diff=left+((right-left)/2);
            if(isvalid(nums,diff,p)){
                right=diff-1;
            }
            else left=diff+1;
        }
        return left;
    }
    boolean isvalid(int[] nums, int d, int p){
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i] <= d){
                count++;
                i+=1;
            }
        }
        return count>=p;
    }
}