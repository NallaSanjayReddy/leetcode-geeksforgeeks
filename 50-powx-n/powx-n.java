class Solution {
    public double myPow(double x, int n) {
        if(n>=0) return findit(x,n);
        else return (double)1/findit(x,n);
    }
    public double findit(double x, int n){
        if(n==0) return 1;
        if(n==1) return x;
        if(n%2==0){
            return findit(x*x,n/2);
        }
        else return findit(x*x,n/2)*x;
    }
}