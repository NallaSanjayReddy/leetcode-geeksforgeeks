class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> etr: hash.entrySet()){
            ans.add(etr.getValue());
        }
        Collections.sort(ans);
        int sum=0;
        int rem=k;
        for(int etr:ans){
            if(rem>=etr){
                rem-=etr;
            }
            else{
                rem=0;
                sum+=1;
            }
        }
        return sum;
    }
}