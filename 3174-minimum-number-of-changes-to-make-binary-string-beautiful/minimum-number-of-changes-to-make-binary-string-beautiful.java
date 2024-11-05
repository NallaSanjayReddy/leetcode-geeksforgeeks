class Solution {
    public int minChanges(String s) {
        char prev=s.charAt(0);
        int val=0;
        int count=1;
        for(int i=1;i<s.length();i++){
            if(prev!=s.charAt(i)){
                if(count%2==0){ 
                    count=1;
                    prev=s.charAt(i);
                }
                else{ 
                    val++;
                    count++;
                }
            }
            else{
                count++;
            }
        }
        return val;
    }
}