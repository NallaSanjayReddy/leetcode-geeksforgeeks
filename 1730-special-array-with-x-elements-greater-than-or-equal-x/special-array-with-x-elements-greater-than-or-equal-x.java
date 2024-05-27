class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int j=0;
        for(int i=0;i<=nums[nums.length-1];i++){
            j=0;
            while(j<nums.length){
                if(i<=nums[j]){
                    if(i==nums.length-j) return i;
                    break;
                }
                else{
                    j++;
                }
            }
        }
        return -1;
    }
}