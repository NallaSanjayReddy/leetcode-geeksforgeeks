class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans=new ArrayList<>();
        HashSet<String> hash=new HashSet<>();
        for(String ele:wordDict){
            hash.add(ele);
        }
        String val="";
        findit(s,hash,ans,val,0);
        return ans;
    }
    public void findit(String s, HashSet<String> hash, List<String> ans, String val, int i){
        if(i==s.length()){
            String val1=val.substring(0,val.length()-1);
            ans.add(val1);
            return;
        }
        for(int j=i;j<s.length();j++){
            String str=s.substring(i,j+1);
            if(hash.contains(str)){
                val+=str+" ";
                findit(s,hash,ans,val,j+1);
                val=val.substring(0,val.length()-(str.length()+1));
            }
        }
    }
}