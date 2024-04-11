class Solution {
    public String removeKdigits(String num, int k) {
        // If k is equal to or greater than the length of num, return "0"
        if (k >= num.length()) return "0";
        
        // Initialize a StringBuilder for the final result
        StringBuilder result = new StringBuilder();
        
        for (char digit : num.toCharArray()) {
            // While k is greater than 0 and the last character of result is greater than the current digit
            while (k > 0 && result.length() != 0 && result.charAt(result.length() - 1) > digit) {
                // Remove the last character from result
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            // Append the current digit to result
            result.append(digit);
        }
        
        // Remove the remaining digits from the end if k is still greater than 0
        while (k > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }
        
        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        // If result is empty, return "0", otherwise return the result as a string
        return result.length() == 0 ? "0" : result.toString();
    }
}
