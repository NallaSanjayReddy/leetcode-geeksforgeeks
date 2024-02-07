class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hash=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hash.put(s.charAt(i),hash.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> ptr=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Character,Integer> etr:hash.entrySet()){
            ptr.add(etr);
        }
        String str="";
        while(ptr.size()>0){
            Map.Entry<Character,Integer> etr=ptr.poll();
            char j=etr.getKey();
            int k=etr.getValue();
            System.out.println(j);
            System.out.println(ptr);
            while(k>0){
                str+=j;
                k--;
            }
        }
        return str;
    }
}