class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        TreeMap<Integer,Integer> hash= new TreeMap<>();
        for(int i=0; i<nums.length;i++){
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);            
        }
        int count=0;
        int i=0;
        int prev=0;
        while(!hash.isEmpty()){
            count=0;
            TreeMap<Integer,Integer> hash1=new TreeMap<>(hash);
            for(Map.Entry<Integer,Integer> etr:hash1.entrySet()){
                if(count<k){
                    if(count==0) prev=etr.getKey()-1;
                    count++;
                    int val=etr.getValue();
                    if(etr.getKey()!=prev+1) return false;
                    if(val-1==0) hash.remove(etr.getKey());
                    else hash.put(etr.getKey(),val-1);
                    prev=etr.getKey();
                }
                else break;
                 
            }
            if (count<k) return false;
        }
        return true;
    }
}