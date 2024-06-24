class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<Integer> hash=new HashSet<>();
        int n=(int)Math.pow(2,k);
        for(int i=0;i<=s.length()-k;i++){
            int val=Integer.parseInt(s.substring(i,i+k),2);
            hash.add(val);
        }
        for(int i=0;i<n;i++){
            if(!hash.contains(i)) return false;
        }
        return true;
    }
}