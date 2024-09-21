class Solution {
    public int maxVowels(String s, int k) {
        int max=0;
        int ans=0;
        for(int i=0;i<k;i++){
            if("aeiou".contains(s.charAt(i)+"")){
                max+=1;
            }
        }
        ans=max;
        for(int i=0;i<=s.length()-k;i++){
            if(i==0) continue;
            if("aeiou".contains(s.charAt(i-1)+"")) max-=1;
            if("aeiou".contains(s.charAt(i+k-1)+"")) max+=1;
            if(max>ans) ans=max;
        }
        return ans;
    }
}