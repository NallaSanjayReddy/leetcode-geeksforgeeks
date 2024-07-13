class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> ptr=new PriorityQueue<>((a,b)->((Math.abs(x-b)-Math.abs(x-a))==0)?b-a:Math.abs(x-b)-Math.abs(x-a));
        for(int ele:arr){
            if(ptr.size()==k){
                ptr.add(ele);
                ptr.poll();
            }
            else ptr.add(ele);
        }
        List<Integer> ans=new ArrayList<>(ptr);
        Collections.sort(ans);
        return ans;
    }
}