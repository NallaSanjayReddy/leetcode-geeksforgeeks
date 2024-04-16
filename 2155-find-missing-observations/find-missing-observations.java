class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=mean*(n+rolls.length);
        int cursum=0;
        for(int i=0;i<rolls.length;i++){
            cursum+=rolls[i];
        }
        int rem=sum-cursum;
        int remmean=rem/n;
        
        if(remmean>6 || remmean<=0){ 
            int ans[]=new int[0];
            return ans;
        }
        if(remmean==6){
            if(rem>(remmean*n)){
                int ans[]=new int[0];
                return ans;    
            } 
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(rem-(remmean*n)>0){
                int val=(rem-(remmean*n))/(n-i);
                ans[i]=remmean+val;
                rem-=val;
            }
            else{
                ans[i]=remmean;
            }
        }
        return ans;
    }
}