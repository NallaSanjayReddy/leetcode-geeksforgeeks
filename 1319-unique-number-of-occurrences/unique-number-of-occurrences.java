class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }
        HashMap<Integer,Integer> hash1=new HashMap<>(hash);
        for(Map.Entry<Integer,Integer> etr: hash.entrySet()){
            hash1.remove(etr.getKey());
            if(hash1.containsValue(etr.getValue())){
                return false;

            }
        }
        return true;
    }
}