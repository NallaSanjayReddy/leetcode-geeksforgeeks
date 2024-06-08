class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        int sum=0;
        hash.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hash.containsKey(sum%k)){
                if(hash.get(sum%k)<i-1) return true;
            }
            if(!hash.containsKey(sum%k)){
                hash.put(sum%k,i);
            }
        }
        return false;
    }
}
class tree{
    int left;
    int right;
    int val;
    tree(int l, int r, int k){
        left=l;
        right=r;
        val=k;
    }
}