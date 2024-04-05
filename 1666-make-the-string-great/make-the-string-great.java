class Solution {
    public String makeGood(String s) {
        StringBuilder str = new StringBuilder(s);
        int i = 1;
        while (i < str.length()) {
            if (Math.abs(str.charAt(i) - str.charAt(i-1)) == 32) {
                str.delete(i-1, i+1);
                // Move back to check for new bad pairs created by the deletion
                i = Math.max(1, i - 1);
            } else {
                i++;
            }
        }
        return str.toString();
    }
}
