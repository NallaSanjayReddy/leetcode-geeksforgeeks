class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left=0;
        int sum=0;
        int max=0;
        for(int right=0;right<s.length();right++){
            sum+=Math.abs(s.charAt(right)-t.charAt(right));
            while(sum>maxCost){
                sum-=Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            max=Math.max(max,1+right-left);
        }
        return max;
    }
}