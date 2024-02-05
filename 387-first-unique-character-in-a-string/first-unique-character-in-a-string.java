class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> hash=new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            if(hash.containsKey(s.charAt(i))) hash.put(s.charAt(i),-1);
            else hash.put(s.charAt(i),i);
        }
        for(Map.Entry<Character,Integer> etr: hash.entrySet()){
            if(etr.getValue()!=-1) return etr.getValue();
        }
        return -1;
    }
}