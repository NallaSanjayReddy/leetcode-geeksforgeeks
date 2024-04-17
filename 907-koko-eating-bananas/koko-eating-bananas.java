class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMaxPile(piles); // Get the maximum pile size as the upper bound for binary search
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid; // If Koko can finish with this speed, try a smaller speed
            } else {
                left = mid + 1; // If Koko can't finish, try a larger speed
            }
        }
        
        return left; // The left pointer will be the minimum speed at which Koko can finish eating
    }
    
    private boolean canFinish(int[] piles, int speed, int h) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed; // Faster way to calculate the ceiling without using Math.ceil
        }
        return time <= h;
    }
    
    private int getMaxPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
