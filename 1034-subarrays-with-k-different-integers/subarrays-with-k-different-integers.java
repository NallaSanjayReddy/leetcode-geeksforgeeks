class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int start = 0, end = 0, count = 0;
        while (end < nums.length) {
            countMap.put(nums[end], countMap.getOrDefault(nums[end], 0) + 1);
            while (countMap.size() > k) {
                countMap.put(nums[start], countMap.get(nums[start]) - 1);
                if (countMap.get(nums[start]) == 0) {
                    countMap.remove(nums[start]);
                }
                start++;
            }
            count += end - start + 1;
            end++;
        }
        return count;
    }
}
