class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,StringBuilder> hash=new HashMap<>(); 
        for(int i=0;i<s.length();i++){
            if(!hash.containsKey(s.charAt(i))) hash.put(s.charAt(i),new StringBuilder());
            hash.put(s.charAt(i),hash.get(s.charAt(i)).append(s.charAt(i)));
        }
        System.out.println(hash);
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<order.length();i++){
            if(s.indexOf(order.charAt(i)+"")!=-1){
                ans.append(hash.get(order.charAt(i)));
            }
        }
        for(int i=0;i<s.length();i++){
            if(ans.indexOf(s.charAt(i)+"")==-1){
                ans.append(hash.get(s.charAt(i)));
            }
        }
        return ans.toString();
    }
}