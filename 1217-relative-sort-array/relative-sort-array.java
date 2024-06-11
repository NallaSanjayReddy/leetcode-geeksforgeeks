class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        LinkedHashMap<Integer,Integer> hash=new LinkedHashMap<>();
        Arrays.sort(arr1);
        for(int ele:arr2){
            hash.put(ele,0);
        }
        for(int ele:arr1){
            hash.put(ele,hash.getOrDefault(ele,0)+1);
        }
        int i=0;
        while(!hash.isEmpty()){
            int key=hash.firstEntry().getKey();
            int val=hash.firstEntry().getValue();
            hash.pollFirstEntry();
            while(val!=0){
                arr1[i]=key;
                val-=1;
                i++;
            }
        }
        return arr1;
    }
}