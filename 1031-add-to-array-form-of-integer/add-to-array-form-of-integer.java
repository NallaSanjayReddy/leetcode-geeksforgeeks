class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans=new LinkedList<>();
        int carry=0;
        for(int i=num.length-1;i>=0;i--){
            int val=carry+num[i]+(k%10);
            carry=val/10;
            val%=10;
            k/=10;
            ans.addFirst(val);
        }
        carry+=k;
        while(carry>0){
            int etr=carry%10;
            carry/=10;
            ans.addFirst(etr);
        }
        return ans;
    }
}