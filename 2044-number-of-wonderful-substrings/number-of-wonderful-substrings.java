class Solution {
    public long wonderfulSubstrings(String word) {
        long count = 0;
        int[] freq = new int[1024]; // There are 2^10 possible combinations for 10 bits
        int mask = 0; // This will keep track of the current bit representation
        freq[0] = 1; // Empty substring is a valid starting point

        for (char c : word.toCharArray()) {
            mask ^= 1 << (c - 'a'); // Flip the bit corresponding to the current character
            count += freq[mask]; // Add the number of times this mask has occurred

            // Check for all possibilities where only one bit is set to 1
            for (int i = 0; i < 10; i++) {
                count += freq[mask ^ (1 << i)];
            }

            freq[mask]++; // Increment the frequency of the current mask
        }

        return count;
    }
}
