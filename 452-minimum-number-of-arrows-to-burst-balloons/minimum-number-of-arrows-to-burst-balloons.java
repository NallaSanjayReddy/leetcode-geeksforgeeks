class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        // Sort the points based on the end value of each interval
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrowCount = 1;
        int arrowLimit = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            // If the start of the next interval is greater than the current arrow limit,
            // we need another arrow
            if (points[i][0] > arrowLimit) {
                arrowCount++;
                arrowLimit = points[i][1];
            }
        }
        
        return arrowCount;
    }
}
