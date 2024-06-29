import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        HashMap<Integer, ArrayList<int[]>> hash = new HashMap<>();
        
        for (int[] ele : times) {
            if (!hash.containsKey(ele[0])) 
                hash.put(ele[0], new ArrayList<>());
            hash.get(ele[0]).add(new int[]{ele[1], ele[2]});
        }
        
        PriorityQueue<int[]> ptr = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        ptr.add(new int[]{k, 0});
        visited[k] = 0;
        
        while (!ptr.isEmpty()) {
            int[] etr = ptr.poll();
            int node = etr[0];
            int time = etr[1];
            
            if (time > visited[node]) continue;
            
            if (hash.containsKey(node)) {
                for (int[] ele : hash.get(node)) {
                    int nextNode = ele[0];
                    int nextTime = time + ele[1];
                    
                    if (nextTime < visited[nextNode]) {
                        visited[nextNode] = nextTime;
                        ptr.add(new int[]{nextNode, nextTime});
                    }
                }
            }
        }
        
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, visited[i]);
        }
        
        return maxTime;
    }
}
