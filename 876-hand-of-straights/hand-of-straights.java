import java.util.Arrays;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand == null || hand.length == 0 || hand.length % groupSize != 0) {
            return false; // Return false if the hand is null, empty, or not divisible by groupSize
        }

        Arrays.sort(hand); // Sort the array to group consecutive numbers

        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != -1) { // Check if the card has not been used in a group
                int count = 1; // Start with the current card
                int prev = hand[i]; // The previous card in the group
                hand[i] = -1; // Mark the card as used

                for (int j = i + 1; j < hand.length && count < groupSize; j++) {
                    if (hand[j] == prev + 1) { // Check if the next card is consecutive
                        prev = hand[j]; // Update the previous card
                        hand[j] = -1; // Mark the card as used
                        count++; // Increment the count of cards in the group
                    }
                }

                if (count != groupSize) {
                    return false; // If the group is not of the correct size, return false
                }
            }
        }

        return true; // If all cards can be grouped correctly, return true
    }
}
