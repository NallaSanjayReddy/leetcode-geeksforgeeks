class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer,HashSet<Integer>> hash=new HashMap<>();
        for(int i=0;i<trust.length;i++){
            if(!hash.containsKey(trust[i][0])) hash.put(trust[i][0],new HashSet<>());
            hash.get(trust[i][0]).add(trust[i][1]);
        }
        System.out.println(hash);
        if(hash.isEmpty() && n==1) return 1;
        if(hash.isEmpty()) return -1;
        int count=0;
        for(int i=1;i<=n;i++){
            if(!hash.containsKey(i)) count++;
        }
        if(count>1) return -1;
        for(int i=1;i<=n;i++){
            if(!hash.containsKey(i)){
                for(int j=1;j<=n && j!=i;j++){
                    if(!hash.get(j).contains(i)) return -1;
                }
                return i;
            }
        }
        
        return -1;
    }
}