class Solution {
    public int minOperations(int[] nums, int k) {
        int[] arr=new int[32];
        for(int i=0;i<nums.length;i++){
            int val=1;
            for(int j=0;j<32;j++){
                if((nums[i]&val)!=0) arr[j]+=1;
                val<<=1;
            }
        }
        int count=0;
        for(int i=0;i<32;i++){
            if(((k&1)==1 && arr[i]%2==0)||((k&1)==0 && arr[i]%2!=0)) count++;
            k>>=1;
        }
        return count;
    }
}