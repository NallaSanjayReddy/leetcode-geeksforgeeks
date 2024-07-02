class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int ele:nums1){
            hash.put(ele,hash.getOrDefault(ele,0)+1);
        }
        ArrayList<Integer> arr=new ArrayList<>();
        for(int ele:nums2){
            if(hash.getOrDefault(ele,0)==0){
                continue;
            }
            else if(hash.getOrDefault(ele,0)==1){
                hash.remove(ele);
                arr.add(ele);
            }
            else{
                hash.put(ele,hash.get(ele)-1);
                arr.add(ele);
            }
        }
        int[] ans=arr.stream().mapToInt(i->(int)i).toArray();
        return ans;
    }
}