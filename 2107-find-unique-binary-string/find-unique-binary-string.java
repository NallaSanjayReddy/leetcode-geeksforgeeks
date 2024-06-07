class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> hash=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hash.add(nums[i]);
        }
        StringBuilder sb=new StringBuilder();
        return findit(sb,nums[0].length(),hash,0);
    }
    public String findit(StringBuilder s, int n, HashSet<String> hash, int i){
        if(i==n){
            String sb=s.toString();
            if(!hash.contains(sb)){
                return sb;
            }
            else{
                return "";
            }
        }
        else{
            s.append("0");
            String sb=findit(s,n,hash,i+1);
            if(sb.length()!=0) return sb;
            s.delete(s.length()-1,s.length());
            s.append("1");
            sb=findit(s,n,hash,i+1);
            if(sb.length()!=0) return sb;
            s.delete(s.length()-1,s.length());
            return "";
        }
    } 
}