class Solution {
    Trie root=new Trie();
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String word:dictionary){
            insert(word);
        }
        StringBuilder result=new StringBuilder();
        String[] input = sentence.split(" ");
        for(String i:input){
            result.append(search(i));
            result.append(" ");
        }
        return result.toString().trim();
    }
    public void insert(String word){
        Trie head=root;
        for(char c:word.toCharArray()){
            int val=(int)(c-'a');
            if(head.children[val]==null){
                head.children[val]=new Trie();
            }
            head=head.children[val];
        }
        head.isEnd=true;
    }
    public String search(String word){
        Trie head=root;
        int j=0;
        for(char c:word.toCharArray()){
            int val=(int)(c-'a');
            j++;
            if(head.children[val]==null){
                return word;
            }
            else if(head.children[val].isEnd){
                return word.substring(0,j);
            }
            else{
                head=head.children[val];
            }
        }
        return word;
    }
}
class Trie{
    Trie[] children;
    boolean isEnd;
    Trie(){
        children=new Trie[26];
        isEnd=false;
    }
}