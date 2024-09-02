class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        // base case
        if(n == target) return 0;
        if(DigitSum(n) <= target) return 0;
   
        long d = 10; // 10, 100, 1000, 10000
        long num = n; // n copy
        while(true) {
            // part 2
            if(d > num) return d - num;   // speacial case : test case : n = 19 , target 1 
                                          // 100 - 19 ->  ans 81
            // part 1
            num /= d;  // test case : 16          -> 1
            num = num * d;  // test case : 1 * 10 -> 10
            num += d;  // test case : 10 + 10     -> 20
            
            if(DigitSum(num) <= target) {    // 2+0 ->  2 < 6(target)
                return num - n;              // return diff ->  20 - 16 == 4
            }
            
            // part 3
            d *= 10;   // unit's place to 10's place
            num = n;   // restore num
        }
        
    }
    public long DigitSum(long num) {
        long sum = 0;
        long d = 0;
        while(num > 0) {
            d = num % 10;
            sum += d;
            num /= 10;
        }
        return sum;
    }
}