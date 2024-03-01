class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count=0;
        int count1=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
            else{
                count1++;
            }
        }
        String str="";
        
        for(int i=1;i<count;i++){
            str="1"+str;
        }
        for(int i=0;i<count1;i++){
            str+="0";
        }
        str+="1";
        return str;
    }
}