class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int left=height[0];
        int right=height[height.length-1];
        int i=0;
        int j=height.length-1;
        max=Math.min(left,right)*(height.length-1);
        while(i<j){
            if(left<height[i]){
                if(max<Math.min(height[i],right)*(j-i)) max=Math.min(height[i],right)*(j-i);
                left=height[i];
            }
            if(right<height[j]){
                if(max<Math.min(height[j],left)*(j-i)) max=Math.min(height[j],left)*(j-i);
                right=height[j];
            }
            if(left<right){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }
}