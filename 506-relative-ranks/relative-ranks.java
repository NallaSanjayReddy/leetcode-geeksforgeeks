class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> ptr=new PriorityQueue<>((a,b)->(b-a));
        for(int i=0;i<score.length;i++){
            ptr.add(score[i]);
        }
        HashMap<Integer,Integer> hash=new HashMap<>();
        int i=1;
        while(!ptr.isEmpty()){
            hash.put(ptr.poll(),i);
            i++;
        }
        String ans[]=new String[score.length];
        for(i=0;i<score.length;i++){
            if(hash.get(score[i])==1){
                ans[i]="Gold Medal";
            }
            else if(hash.get(score[i])==2){
                ans[i]="Silver Medal";
            }
            else if(hash.get(score[i])==3){ 
                ans[i]="Bronze Medal";
            }
            else ans[i]=hash.get(score[i])+"";
        }
        return ans;
    }
}