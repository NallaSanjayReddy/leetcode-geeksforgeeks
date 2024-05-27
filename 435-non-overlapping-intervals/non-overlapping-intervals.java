class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort the intervals based on their start time
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        // Initialize the previous interval's end to the first interval's end
        int prevEnd = intervals[0][1];
        // Initialize the count of intervals to erase
        int count = 0;

        // Iterate over all intervals starting from the second one
        for(int i = 1; i < intervals.length; i++){
            // If the current interval's start is less than the previous interval's end, they overlap
            if(intervals[i][0] < prevEnd){
                // Increase the count of intervals to erase
                count++;
                // Update the previous interval's end to the minimum of the current and previous interval's end
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            } else {
                // If they don't overlap, update the previous interval's end to the current one's end
                prevEnd = intervals[i][1];
            }
        }
        // Return the count of erased intervals
        return count;
    }
}
