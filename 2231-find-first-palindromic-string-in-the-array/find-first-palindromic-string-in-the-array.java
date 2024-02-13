class Solution {
    public String firstPalindrome(String[] words) {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<words.length;i++){
            str=new StringBuilder(words[i]);
            if(str.reverse().toString().equals(words[i])){
                return words[i];
            }
        }
        return "";
    }
}