class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hash=new HashSet<>();
        HashSet<Integer> hash1=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            hash.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(hash.contains(nums2[i]) && !hash1.contains(nums2[i])){
                hash1.add(nums2[i]);
            }
        }
        int ans[]=new int[hash1.size()];
        Iterator itr=hash1.iterator();
        int i=0;
        while(itr.hasNext()){
            ans[i]=(int)itr.next();
            i++;
        }
        return ans;
    }
}