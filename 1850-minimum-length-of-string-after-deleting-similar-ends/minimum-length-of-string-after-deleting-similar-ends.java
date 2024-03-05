class Solution {
    public int minimumLength(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                char curr=s.charAt(i);
                while(i<s.length() && curr==s.charAt(i)){
                    i++;
                }
                while(j>0 && curr==s.charAt(j)){
                    j--;
                }
                if(i>j) return 0;
            }
            else break;
        }
        return j+1-i;
    }
}