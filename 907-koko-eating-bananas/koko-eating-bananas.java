class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int sum=0;
        Arrays.sort(piles);
        if(h==piles.length) return piles[piles.length-1];
        int l = 1;
        int r = piles[piles.length - 1];
        while (l < r) { // Change this to l < r to ensure we don't miss the correct answer
            int mid = l + (r - l) / 2;
            long val = 0;
            for (int pile : piles) {
                val += (long) Math.ceil((double) pile / mid);
            }
            if (val > h) {
                l = mid + 1; // If we need more hours than h, increase the speed
            } else {
                r = mid; // If we can finish within h hours, try to see if there's a slower speed possible
            }
        }
        return l;
    }
}