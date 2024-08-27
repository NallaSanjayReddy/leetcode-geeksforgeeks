import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            arr.get(u).add(new Pair(v, prob));
            arr.get(v).add(new Pair(u, prob));
        }

        double[] visited = new double[n];
        visited[start_node] = 1.0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.val, a.val));
        pq.add(new Pair(start_node, 1.0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.key;
            double prob = curr.val;

            for (Pair neighbor : arr.get(node)) {
                int nextNode = neighbor.key;
                double nextProb = neighbor.val * prob;

                if (nextProb > visited[nextNode]) {
                    visited[nextNode] = nextProb;
                    pq.add(new Pair(nextNode, nextProb));
                }
            }
        }

        return visited[end_node]; // No path from start_node to end_node
    }
}

class Pair {
    int key;
    double val;

    Pair(int k, double v) {
        key = k;
        val = v;
    }
}
