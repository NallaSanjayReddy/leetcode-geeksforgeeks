class Solution {
    public int numSteps(String s) {
        int count = 0;
        while (!s.equals("1")) {
            if (s.charAt(s.length() - 1) == '1') {
                // Increment the binary number
                StringBuilder ans = new StringBuilder();
                int carry = 1;
                for (int i = s.length() - 1; i >= 0; i--) {
                    if (s.charAt(i) == '1' && carry == 1) {
                        ans.insert(0, '0');
                    } else {
                        if (carry == 1 && s.charAt(i) == '0') {
                            ans.insert(0, '1');
                            carry = 0; // Carry is consumed
                        } else {
                            ans.insert(0, s.charAt(i));
                        }
                    }
                }
                if (carry == 1) {
                    ans.insert(0, '1'); // If there's still a carry, add it to the front
                }
                s = ans.toString();
            } else {
                // Divide the number by 2
                s = s.substring(0, s.length() - 1);
            }
            count++;
        }
        return count;
    }
}
