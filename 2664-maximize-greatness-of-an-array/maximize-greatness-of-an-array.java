class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int val=0;
        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[i]<nums[j]){ 
                val++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return val;
    }
}
