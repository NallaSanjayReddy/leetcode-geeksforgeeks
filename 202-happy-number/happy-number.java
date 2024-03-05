class Solution {
    public boolean isHappy(int n) {
        int sum=0;
        HashSet<Integer> val=new HashSet<Integer>();
        while(!(sum==1 && n==0)){
            if(n>0){
                sum+=Math.pow(n%10,2);
                n/=10;
            }
            if(n==0 && sum>1){
                if(val.contains(sum)) return false;
                else{
                    val.add(sum);
                } 
                n=sum;
                sum=0;
            }
        }
        return (sum==1);
    }
}