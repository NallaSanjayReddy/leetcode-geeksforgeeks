class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>(); 
        int l=0;
        int r=0;
        HashMap<Character,Integer> hash =new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            hash.put(s.charAt(i),hash.getOrDefault(s.charAt(i),0)+1);
        }
        HashMap<Character,Integer> hashi=new HashMap<>();
        for(int i=0;i<s.length();i++){
            r++;
            hashi.put(s.charAt(i),hashi.getOrDefault(s.charAt(i),0)+1);
            boolean isok=true;
            for(Map.Entry<Character,Integer> etr:hashi.entrySet()){
                if(hash.get(etr.getKey())!=etr.getValue()) isok=false;
            }
            if(isok){
                ans.add(r-l);
                hashi=new HashMap<>();
                l=i+1;
                r=i+1;
            }
        }
        return ans;
    }
}