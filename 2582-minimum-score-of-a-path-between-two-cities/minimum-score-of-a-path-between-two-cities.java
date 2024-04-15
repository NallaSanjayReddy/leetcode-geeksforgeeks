class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            if (!graph.containsKey(road[0])) {
                graph.put(road[0], new HashMap<>());
            }
            if (!graph.containsKey(road[1])) {
                graph.put(road[1], new HashMap<>());
            }
            graph.get(road[0]).put(road[1], road[2]);
            graph.get(road[1]).put(road[0], road[2]);
        }
        int minScore = Integer.MAX_VALUE;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int adj : graph.get(node).keySet()) {
                if (!visited.contains(adj)) {
                    queue.offer(adj);
                    visited.add(adj);
                }
                minScore = Math.min(minScore, graph.get(node).get(adj));
            }
        }
        return minScore;
    }
}