class Solution {
    public int appendCharacters(String s, String t) {
        return findit(s,t,0,0);
    }
    int findit(String s, String t, int i, int j){
        if(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)) return findit(s,t,i+1,j+1);
            else{
                return findit(s,t,i+1,j);
            }
        }
        else if(j<t.length()){
            return t.length()-j;
        }
        else{
            return 0;
        }
    }
}