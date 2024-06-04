class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hash=new HashMap<>();
        int count=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            hash.put(s.charAt(i),hash.getOrDefault(s.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> etr:hash.entrySet()){
            if(etr.getValue()%2==0){
                count+=etr.getValue();
            }
            else{
                count+=etr.getValue()-1;
                max=1;
            }
        }
        return count+max;
    }
}