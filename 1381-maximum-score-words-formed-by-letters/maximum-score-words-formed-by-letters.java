class Solution {
    int max=0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        HashMap<Character,Integer> hash=new HashMap<>();
        for(int i=0;i<letters.length;i++){
            hash.put(letters[i],hash.getOrDefault(letters[i],0)+1);
        }
        findit(words,hash,score,0,0);
        return max;
    }
    public void findit(String[] words, HashMap<Character,Integer> hash, int[] score, int i, int val){
        if(i==words.length){
            if(max<val) max=val;
            return;
        }
        findit(words,hash,score,i+1,val);
        if(check(words[i],hash)){
            int val1=val;
            for(int j=0;j<words[i].length();j++){
                if(hash.get(words[i].charAt(j))==1) hash.remove(words[i].charAt(j));
                else hash.put(words[i].charAt(j),hash.get(words[i].charAt(j))-1);
                val1+=score[words[i].charAt(j) - 'a'];
            }
            findit(words,hash,score,i+1,val1);
            for(int j=0;j<words[i].length();j++){
                hash.put(words[i].charAt(j),hash.getOrDefault(words[i].charAt(j),0)+1);
            }
        }
    }
    public boolean check(String word, HashMap<Character,Integer> hash){
        HashMap<Character,Integer> hash1=new HashMap<>();
        for(int i=0;i<word.length();i++){
            if(hash.containsKey(word.charAt(i)) && hash1.getOrDefault(word.charAt(i),0)<hash.get(word.charAt(i))){
                hash1.put(word.charAt(i),hash1.getOrDefault(word.charAt(i),0)+1);
            } 
            else return false;
        }
        return true;
    }
}
