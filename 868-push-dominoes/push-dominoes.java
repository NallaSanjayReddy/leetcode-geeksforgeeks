class Solution {
    public String pushDominoes(String dominoes) {
        char[] str=dominoes.toCharArray();
        StringBuilder s=new StringBuilder();
        boolean hasChange=true;
        while(hasChange){
            HashSet<Integer> hashR=new HashSet<>();
            HashSet<Integer> hashL=new HashSet<>();
            hasChange=false;
            for(int i=0;i<str.length;i++){
                if(str[i]=='R' && ((i<str.length-2 && str[i+1]=='.' && str[i+2]!='L') || (i==str.length-2 && str[i+1]=='.'))){
                    hashR.add(i+1);
                    hasChange=true;
                }
                else if(str[i]=='L' && ((i>1 && str[i-1]=='.' && str[i-2]!='R')||(i==1 && str[i-1]=='.'))){
                    hashL.add(i-1);
                    hasChange=true;
                }
            }
            for(int ele:hashR){
                str[ele]='R';
            }
            for(int ele:hashL){
                str[ele]='L';
            }
        }
        for(int i=0;i<str.length;i++){
            s.append(str[i]);
        }
        return s.toString();
    }
}