class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<TreeMap<Character,Integer>> hash=new ArrayList<TreeMap<Character,Integer>>();
        List<List<String>> ans=new ArrayList<List<String>>();
        for(int i=0;i<strs.length;i++){
            hash.add(new TreeMap<>());
            for(int j=0;j<strs[i].length();j++){
                hash.get(i).put(strs[i].charAt(j),hash.get(i).getOrDefault(strs[i].charAt(j),0)+1);
            }
        }
        String[] hashes=new String[hash.size()];
        for(int i=0;i<hash.size();i++){
            hashes[i]=hash.get(i)+"";
        }
        List<List<String>> anshash=new ArrayList<>();
        boolean ready=false;
        for(int i=0;i<hashes.length;i++){
            ready=false;
            for(int j=0;j<anshash.size();j++){
                if(anshash.get(j).get(0).equals(hashes[i])){
                    ans.get(j).add(strs[i]);
                    ready=true;
                    break;
                }
            }
            if(!ready){
                anshash.add(new ArrayList<String>());
                anshash.get(anshash.size()-1).add(hashes[i]);
                ans.add(new ArrayList<String>());
                ans.get(ans.size()-1).add(strs[i]);
            }
        }
        return ans;
    }
}