class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,HashSet<Integer>> hash=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            if(!hash.containsKey(edges[i][0])) hash.put(edges[i][0],new HashSet<>());
            hash.get(edges[i][0]).add(edges[i][1]);
            if(!hash.containsKey(edges[i][1])) hash.put(edges[i][1],new HashSet<>());
            hash.get(edges[i][1]).add(edges[i][0]);
        }
        int max=0;
        int val=0;
        for(Map.Entry<Integer,HashSet<Integer>> etr:hash.entrySet()){
            if(max<etr.getValue().size()){
                max=etr.getValue().size();
                val=etr.getKey();
            }
        } 
        return val;
    }
}