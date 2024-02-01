class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans[][]=new int[nums.length/3][3];
        int j=0;
        int i=0;
        while(i<nums.length-2){
            if(nums[i+1]-nums[i]<=k && nums[i+2]-nums[i]<=k){
                ans[j][0]=nums[i];
                ans[j][1]=nums[i+1];
                ans[j][2]=nums[i+2];
                j++;
                i+=3;
            }
            else return new int[0][0];
        }
        return ans;
    }
}