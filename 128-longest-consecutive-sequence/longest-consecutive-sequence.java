class Solution {
    int max=0;
    public int longestConsecutive(int[] nums) {
        HashMap<Long,Integer> hash=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hash.put((long)nums[i],i);
        }
        int count=0;
        int[] visited=new int[nums.length];
        Arrays.fill(visited,0);
        for(int i=0;i<nums.length;i++){
            findit(nums,visited,hash,i);
        }
        return max;
    }
    public void findit(int[] nums, int[] visited, HashMap<Long,Integer> hash, int i){
        if(i<nums.length){
            if(visited[i]==0){
                visited[i]=1;
                if(hash.containsKey((long)nums[i]-(long)1)){
                    findit(nums,visited,hash,hash.get((long)nums[i]-(long)1));
                    visited[i]+=visited[hash.get((long)nums[i]-(long)1)];
                }
            }
            if(max < visited[i]) max=visited[i];
        }
        return;
    }
}