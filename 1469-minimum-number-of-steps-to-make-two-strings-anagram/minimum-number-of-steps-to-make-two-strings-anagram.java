class Solution {
    public int minSteps(String s, String t) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        int count=0;
        for(int i=0;i<t.length();i++){
            if(arr[t.charAt(i)-'a']>0){ 
                arr[t.charAt(i)-'a']--;
            }
            else{
                count++;
            }
        }
        int curr=0;
        for(int i=0;i<26;i++){
            if(arr[i]>0){ 
                if(count>curr){
                    curr++;
                }
                else{
                    curr++;
                    count++;
                }
            }
        }
        return count;
    }
}