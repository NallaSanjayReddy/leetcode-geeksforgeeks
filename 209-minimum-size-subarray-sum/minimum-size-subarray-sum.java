class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] prev=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target) return 1;
            prev[i]=((i==0)?0:prev[i-1])+nums[i];
        }
        int min=Integer.MAX_VALUE;
        int left=0;
        for(int i=0;i<prev.length;i++){
            if(prev[i]>=target){
                min=Math.min(min,i+1);
                int j=left;
                while(prev[i]-prev[j]>=target){
                    min=Math.min(i-j,min);
                    j++;
                }
            }
        }
        return (min==Integer.MAX_VALUE)?0:min;
    }
}