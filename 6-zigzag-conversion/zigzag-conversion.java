class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s; // No need to convert for a single row
        }

        String[] arr = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = ""; // Initialize each row
        }

        int val = (2 * numRows) - 2;
        for (int i = 0; i < s.length(); i++) {
            int row = i % val;
            if (row >= numRows) {
                row = val - row; // Adjust for zigzag pattern
            }
            arr[row] += s.charAt(i);
        }

        StringBuilder ans = new StringBuilder();
        for (String rowStr : arr) {
            ans.append(rowStr);
        }

        return ans.toString();
    }
}
