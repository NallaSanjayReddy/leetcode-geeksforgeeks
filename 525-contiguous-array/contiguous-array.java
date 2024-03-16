class Solution {
    public int findMaxLength(int[] nums) {
        int sum=0;
        int max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]==1)?1:-1;
            nums[i]=sum;
            if(sum==0){
                max=Math.max(max,(i-0)+1);
            }
            if(map.containsKey(nums[i])){
                max=Math.max(max,(i-map.get(nums[i])));
            }
            else map.put(nums[i],i);
        }
        return max;
    }
}