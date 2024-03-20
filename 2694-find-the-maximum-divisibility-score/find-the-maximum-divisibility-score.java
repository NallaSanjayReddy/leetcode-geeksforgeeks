class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int max=0;
        Arrays.sort(divisors);
        int index=divisors[0];
        for(int ele:divisors){
            int count=0;
            for(int i=0; i<nums.length;i++){
                if(nums[i]%ele==0) count++;
            }
            if(max<count){ 
                max=count;
                index=ele;
            }
        }
        return index;
    }
}