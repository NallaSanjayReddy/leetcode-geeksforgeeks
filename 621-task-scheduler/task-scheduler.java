class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        // Max heap to store frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(freq[i]);
            }
        }
        int time = 0;
        // Process tasks until the heap is empty
        while (!maxHeap.isEmpty()) {
            int cycle = n + 1;
            List<Integer> remaining = new ArrayList<>();
            int taskCount = 0;
            // Execute tasks in each cycle
            while (cycle-- > 0 && !maxHeap.isEmpty()) {
                int currentFreq = maxHeap.poll();
                if (currentFreq > 1) {
                    remaining.add(currentFreq - 1);
                }
                taskCount++;
            }
            // Restore updated frequencies to the heap
            for (int counts : remaining) {
                maxHeap.add(counts);
            }
            // Add time for the completed cycle
            time += (maxHeap.isEmpty() ? taskCount : n + 1);
        }
        return time;
    }
}