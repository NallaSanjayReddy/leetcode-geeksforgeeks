class Solution {
    public int getLucky(String s, int k) {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            str.append((int)(s.charAt(i)-'a')+1);
        }
        int val=0;
        for(int i=0;i<str.length();i++){
            val+=(int)(str.charAt(i)-'0');
        }
        k--;
        while(k>0){
            int etr=val;
            val=0;
            while(etr>0){
                val+=etr%10;
                etr/=10;
            }
            k--;
        }
        return val;
    }
}