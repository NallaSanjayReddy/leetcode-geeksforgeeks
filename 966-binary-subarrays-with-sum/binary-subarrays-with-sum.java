class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0;
        for(int i=0;i<=nums.length-1;i++){
            int sum=0;
            for(int j=i;j<=nums.length-1 && sum<=goal;j++){
                sum+=nums[j];
                if(sum==goal) count++;
            }
        }
        return count;
    }
}