class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length;
        int max=0;
        HashSet<Integer> hash=new HashSet<>();
        for (int i=0; i<n; i++) {
            if (hash.contains(-nums[i])) {
                max=Math.max(max,Math.abs(nums[i]));
            }
            else hash.add(nums[i]);
        }
        if(max!=0) return max;
        return -1;  // If no such pair found
    }
}