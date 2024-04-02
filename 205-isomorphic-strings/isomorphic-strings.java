class Solution {
    public boolean isIsomorphic(String s, String t) {
        LinkedHashMap<Character,HashSet<Integer>> hash1=new LinkedHashMap<>();
        LinkedHashMap<Character,HashSet<Integer>> hash2=new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            if(!hash1.containsKey(s.charAt(i))) hash1.put(s.charAt(i),new HashSet<Integer>());
            hash1.get(s.charAt(i)).add(i);
            if(!hash2.containsKey(t.charAt(i))) hash2.put(t.charAt(i),new HashSet<Integer>());
            hash2.get(t.charAt(i)).add(i);
        }
        System.out.println(hash1.values());
        System.out.println(hash2.values());
        if(hash1.size()!=hash2.size()) return false;
        else{
            Iterator itr1=hash1.values().iterator();
            Iterator itr2=hash2.values().iterator();
            while(itr1.hasNext()){
                if(!itr1.next().equals(itr2.next())) return false; 
            }
        }
        return true;
    }
}