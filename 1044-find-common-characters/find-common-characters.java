class Solution {
    public List<String> commonChars(String[] words) {
        int[] cr=new int[26];
        for(int j=0;j<words[0].length();j++){
            cr[words[0].charAt(j)-'a']++;
        }
        for(int i=1;i<words.length;i++){
            int[] cri=new int[26];
            for(int j=0;j<words[i].length();j++){
                cri[words[i].charAt(j)-'a']++;
            }
            for(int j=0;j<26;j++){
                cr[j]=Math.min(cr[j],cri[j]);
            }
        }
        List<String> ans=new ArrayList<String>();
        for(int i=0;i<26;i++){
            while(cr[i]>0){
                char val=(char)(97+i);
                ans.add(val+"");
                cr[i]--;
            } 
        } 
        return ans;
    }
}