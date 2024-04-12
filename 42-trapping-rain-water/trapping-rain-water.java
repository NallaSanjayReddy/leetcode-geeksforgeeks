class Solution {
    public int trap(int[] height) {
        if(height.length <= 2) return 0;
        int maxl = height[0];
        int maxr = 0;
        int i = 1;
        int index = 1; // Initialize index to 1 instead of 0
        int sum = 0;
        while(i < height.length - 1) {
            if(maxl <= height[i]){
                maxl = height[i];
                i++;
            } else {
                if(index <= i){
                    index = i + 1;
                    maxr = height[index];
                    for(int j = index + 1; j < height.length; j++){ // Use for-loop for clarity
                        if(height[j] > maxr){
                            maxr = height[j];
                            index = j;
                        }
                    }
                }
                
                if(maxr > height[i]) {
                    sum += Math.min(maxl, maxr) - height[i];
                    i++;
                } else {
                    // If no higher bar is found on the right, move the pointer to the next element
                    i++;
                }
            }
        }
        return sum;
    }
}
