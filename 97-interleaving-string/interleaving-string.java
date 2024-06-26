class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return memoDp(s1, s2, s3);
    }
    
    public static boolean memoDp(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        return memoDp(s1, s2, s3, 0, 0, 0, memo);
    }
    private static boolean memoDp(String s1, String s2, String s3, int i, int j, int k, int[][] memo){
        if(k == s3.length()){
            return true;
        }
        if(memo[i][j] != 0){
            return memo[i][j] == 2;
            // return memo[i][j];
        }
        boolean flag = false;

        if(i == s1.length()){
            flag = s2.charAt(j) == s3.charAt(k) && memoDp(s1, s2, s3, i, j + 1, k + 1, memo);
        }
        else if(j == s2.length()){
            flag = s1.charAt(i) == s3.charAt(k) && memoDp(s1, s2, s3, i + 1, j, k + 1, memo);
        }
        else{
            flag = (s2.charAt(j) == s3.charAt(k) && memoDp(s1, s2, s3, i, j + 1, k + 1, memo)) || (s1.charAt(i) == s3.charAt(k) && memoDp(s1, s2, s3, i + 1, j, k + 1, memo));
        }
        if(flag == true){
            memo[i][j] = 2;
        }
        else{
            memo[i][j] = 1;
        }
        return memo[i][j] == 2;
    }
}