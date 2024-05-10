class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        TreeMap<Double,int[]> ptr=new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                double val=(double)arr[i]/arr[j];
                if(ptr.size()==k){ 
                    if(ptr.lastEntry().getKey()>val){
                        ptr.pollLastEntry();
                        ptr.put(val,new int[]{i,j});
                    }
                }
                else{
                    ptr.put(val,new int[]{i,j});
                }
            }
        }
        int[] etr=ptr.lastEntry().getValue();
        return new int[] {arr[etr[0]],arr[etr[1]]};
    }
}