import java.util.Arrays;

public class Solution {
    public boolean isFive(int num) {
        while (num > 1) {
            if (num % 5 != 0) {
                return false;
            }
            num /= 5;
        }
        return num == 1;
    }

    public boolean isSubstringBeautiful(int i, int j, String s) {
        String str = s.substring(i, j + 1);
        int k = 0;
        while (k < str.length()) {
            if (str.charAt(k) == '0') {
                k++;
                return false;
            } else {
                break;
            }
        }
        int ans = 0;
        for (int m = str.length() - 1; m >= 0; m--) {
            if (str.charAt(m) == '1') {
                ans += (1 << (str.length() - 1 - m));
            }
        }
        return isFive(ans);
    }

    public int func(int idx, String s, int[] dp) {
        if (idx == s.length())
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int min_part = (int) 1e9;
        for (int j = idx; j < s.length(); j++) {
            if (isSubstringBeautiful(idx, j, s)) {
                int cost = 1 + func(j + 1, s, dp);
                min_part = Math.min(cost, min_part);
            }
        }
        dp[idx] = min_part;
        return min_part;
    }

    public int minimumBeautifulSubstrings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        int x = func(0, s, dp);
        return x == 1e9 ? -1 : x;
    }
}
