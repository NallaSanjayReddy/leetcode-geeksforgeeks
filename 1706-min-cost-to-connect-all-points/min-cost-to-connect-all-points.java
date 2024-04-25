class Solution {
    public int minCostConnectPoints(int[][] points) {
        // Custom comparator for the priority queue to sort by distance
        Comparator<int[]> comp = (a, b) -> Integer.compare(a[2], b[2]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);

        // Add initial edges from the first point to the priority queue
        for (int i = 1; i < points.length; i++) {
            int dist = Math.abs(points[0][0] - points[i][0]) + Math.abs(points[0][1] - points[i][1]);
            pq.offer(new int[]{0, i, dist});
        }

        // Array to keep track of visited points
        boolean[] visited = new boolean[points.length];
        visited[0] = true; // Mark the first point as visited

        int result = 0; // Total cost to connect all points
        int edges = 0; // Number of edges added to the MST

        // While there are still edges to consider and we haven't connected all points
        while (!pq.isEmpty() && edges < points.length - 1) {
            int[] edge = pq.poll();
            int point1 = edge[0];
            int point2 = edge[1];
            int cost = edge[2];

            // If the second point is not visited, add the edge to the MST
            if (!visited[point2]) {
                visited[point2] = true; // Mark the point as visited
                result += cost; // Add the cost to the total
                edges++; // Increment the number of edges in the MST

                // Add new edges from the newly connected point
                for (int i = 0; i < points.length; i++) {
                    if (!visited[i]) {
                        int newDist = Math.abs(points[point2][0] - points[i][0]) + Math.abs(points[point2][1] - points[i][1]);
                        pq.offer(new int[]{point2, i, newDist});
                    }
                }
            }
        }

        return result;
    }
}
