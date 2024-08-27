class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        findit(nums,0,ans,list);
        return ans;
    }
    void findit(int[] nums, int i, List<List<Integer>> ans, List<Integer> list){
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        else{
            findit(nums,i+1,ans,list);
            list.add(nums[i]);
            findit(nums,i+1,ans,list);
            list.remove(list.size()-1);
        }
    }
}