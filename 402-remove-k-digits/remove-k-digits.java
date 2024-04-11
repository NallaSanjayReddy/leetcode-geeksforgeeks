class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        char[] arr = num.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';
            while (!pq.isEmpty() && pq.peek()[0] > digit && k > 0) {
                int[] top = pq.poll();
                arr[top[1]] = '*'; // Mark as removed
                k--;
            }
            pq.offer(new int[]{digit, i});
        }
        
        while (k > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            arr[top[1]] = '*'; // Mark as removed
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (char c : arr) {
            if (c == '*') continue; // Skip removed digits
            if (c == '0' && leadingZero) continue; // Skip leading zeros
            leadingZero = false; // First non-zero digit encountered
            sb.append(c);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
