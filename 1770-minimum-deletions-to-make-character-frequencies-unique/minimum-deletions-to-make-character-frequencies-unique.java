class Solution {
    public int minDeletions(String s) {
        int[] chars=new int[26];
        for(int i=0;i<s.length();i++){
            chars[s.charAt(i)-'a']++;
        }
        HashSet<Integer> hash=new HashSet<>();
        int sum=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]==0) continue;
            if(hash.contains(chars[i])){
                while(chars[i]>0){
                    if(hash.contains(chars[i])){
                        chars[i]--;
                        sum++;
                    }
                    else{
                        hash.add(chars[i]);
                        break;
                    }
                }
            }
            else{
                hash.add(chars[i]);
            }
            System.out.println(hash+", "+sum);
        }
        return sum;
    }
}