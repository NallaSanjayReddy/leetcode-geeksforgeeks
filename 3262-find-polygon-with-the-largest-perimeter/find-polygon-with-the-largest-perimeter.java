class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int i=nums.length-1;
        while(i>=2){
            if(2*nums[i]>=sum){
                sum-=nums[i];
                i--;
            }
            else return sum;
        }
        return -1;
    }
}