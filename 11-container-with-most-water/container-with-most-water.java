class Solution {
    public int maxArea(int[] height) {
        int first=height[0];
        int last=height[height.length-1];
        int max=Math.min(first,last)*(height.length-1);
        int i=0;
        int j=height.length-1;
        while(i<j){
            if(first<last){
                i++;
                if(height[i]>first){
                    first=height[i];
                    max=Math.max(max,Math.min(first,last)*(j-i));
                }
            }
            else{
                j--;
                if(height[j]>last){
                    last=height[j];
                    max=Math.max(max,Math.min(first,last)*(j-i));
                }
            }
        }
        return max;
    }
}