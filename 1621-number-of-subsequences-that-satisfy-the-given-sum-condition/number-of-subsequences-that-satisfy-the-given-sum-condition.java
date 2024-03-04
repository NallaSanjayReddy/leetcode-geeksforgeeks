class Solution {
    private static final int MOD = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long[] powersOfTwo = new long[nums.length+1];
        powersOfTwo[0] = 1;
        for (int i = 1; i <=nums.length; i++) 
            powersOfTwo[i] = (powersOfTwo[i - 1] * 2) % MOD;
        
        int count = 0, right = nums.length - 1, left = 0;
        while (left <= right) {
            int sum = nums[right] + nums[left];
            if (sum > target) {
                long seqs = powersOfTwo[right - left]-1;
                count = (int)((count + seqs + 1) % MOD);
                right--;
            } else left++;  
        }
        long totalSeqs = powersOfTwo[nums.length]-1;
        return (int)(totalSeqs - count + MOD) % MOD;
    }
}