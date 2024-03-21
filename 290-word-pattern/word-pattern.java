class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] arr1=pattern.toCharArray();
        String[] arr2=s.split(" ");
        System.out.println(arr1.length+" "+arr2.length);
        if(arr1.length!=arr2.length) return false;
        HashMap<Character,String> hash=new HashMap<>();
        HashSet<String> hashi=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            if(!hash.containsKey(arr1[i])){
                if(hashi.contains(arr2[i])) return false;
                hashi.add(arr2[i]);
                hash.put(arr1[i],arr2[i]);
            }
            else{ 
                if(!hash.get(arr1[i]).equals(arr2[i])) return false; 
            }
        }
        return true;
    }
}