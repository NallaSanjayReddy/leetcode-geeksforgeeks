class Solution {
    HashMap<Integer,ArrayList<Integer>> hash;
    public Solution(int[] nums) {
        int i=0;
        hash=new HashMap<>();
        for(int ele:nums){
            if(!hash.containsKey(ele)) hash.put(ele,new ArrayList<>());
            hash.get(ele).add(i);
            i++;
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> arr=hash.get(target);
        return arr.get((int)(Math.random()*(double)arr.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */