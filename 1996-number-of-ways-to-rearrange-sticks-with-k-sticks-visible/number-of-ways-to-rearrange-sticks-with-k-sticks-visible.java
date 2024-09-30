import java.util.*;


class Solution {

    // Circular perm: N!/N
    // Perm of M from N options:  A(n,m) = n!/(n-m)!
    // Circular perm of M from N options:  Cir(n,m) = (n!/(n-m)!)/m = n!/((n-m)! * m)
    // Circ(n-1,m-1) = (n-1)!        =      (n-1)!
    //                 (n-1-m+1)!*(m-1)     (n-m)!(m - 1)
    // Circ(n,m) = (n)!
    //           (n-m)!*m


    // Number of ways to create J circular permutations from I numbers
    // dp[i][j] = dp[i-1][j-1] + dp[i-1][j] * (i - 1)
    //              {i}        +    {}
    // dp[i-1][j-1] and we count {i} the ith item as a circular permutation by itself
    // dp[i-1][j] and inject into each of those circPerm ith item at every possible position


    /////////
    // We notice the total arrangement can be split into K intervals, each with a leader
    // and all followers within an interval are smaller.
    
    // Followers can be permuted within an interval. Also intervals can have varying lengths
    // So this basically: Find number of ways to build K circular permutations from N elements. 
    
    // k = 1   ways = 1
    // k = n   ways = 1

    // 2 -> 1  ways = 1  [2,1]
    // 2 -> 2  ways = 1  [1,2]

    // n -> k
    // 3 -> 1  ways: 2  [3,2,1]  [3,1,2]
    // 3 -> 2  ways: 3  [1,3,2], [2,3,1], and [2,1,3]

    // dp[3][2] = dp[2][1] + dp[2][2]*(3-1)
    //            [2,1  3] + [1,3,  2] [2,  3,  1]
    // 1) add ith as lone circular permutation at the end
    // 2) inject ith in every possible position


    // dp[4][2] = dp[3][1] + dp[3][2] * (4-1) = 2 + 9 = 11
    //           [_,4,_,_]  = 6
    //           [_,_,4,_]  = 3
    //            3,   = 2
    //            2,   = 1
    //           [3,_,_,4,] = 2   dp[3][1] add ith last as solo circular perm

    public int rearrangeSticks(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            if (i <= k) dp[i][i] = 1;
            for (int j = 1; j < i && j <= k; j++) {
                dp[i][j] = dp[i - 1][j] * (i - 1);
                dp[i][j] %= M;
                dp[i][j] += dp[i - 1][j - 1];
                dp[i][j] %= M;
            }
        }

        return (int) dp[n][k];
    }


    int M = (int) 1e9 + 7;

}