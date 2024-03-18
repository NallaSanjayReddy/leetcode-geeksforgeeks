class Solution {
    public int findMinArrowShots(int[][] points) {
        PriorityQueue<int[]> ptr=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int[] ele:points){
            ptr.add(ele);
        }
        LinkedList<int[]> ans=new LinkedList<>();
        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        while(!ptr.isEmpty()){
            int[] ele=ptr.poll();
            if(start==Integer.MAX_VALUE && end==Integer.MIN_VALUE){
                start=ele[0];
                end=ele[1];
            }
            else if(end<ele[0]){
                ans.add(new int[]{start,end});
                start=ele[0];
                end=ele[1];
            }
            else if(start>ele[1]){
                ans.add(new int[]{start,end});
                start=ele[0];
                end=ele[1];
            }
            else if(start>=ele[0] && end>ele[1]){
                end=ele[1];
            }
            else if(start<ele[0] && end<=ele[1]){
                start=ele[0];
            }
            else if(start<ele[0] && end>ele[1]){
                start=ele[0];
                end=ele[1];
            }
            else if(start>=ele[0] && end<=ele[1]){
                continue;
            }
        }
        ans.add(new int[]{start,end});
        System.out.println(ans);
        return ans.size();
    }
}