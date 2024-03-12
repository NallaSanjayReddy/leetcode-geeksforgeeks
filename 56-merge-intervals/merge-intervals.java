class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> ptr=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for(int i=0;i<intervals.length;i++){
            ptr.add(intervals[i]);
        }
        List<int[]> list=new LinkedList<>();
        int i=0;
        while(!ptr.isEmpty()){
            int ele[]=ptr.poll();
            if(i!=0){
                if(list.get(i-1)[0]<=ele[0] && ele[0]<=list.get(i-1)[1]){
                    if(list.get(i-1)[1]>=ele[1]){
                        continue;
                    }
                    else{
                        list.get(i-1)[1]=ele[1];
                        continue;
                    }
                }
            }  
            list.add(ele);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}