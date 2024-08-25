class Solution {
    public int countPairs(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(findit(nums[i],nums[j])<=2){
                    count++;
                }
            }
        }
        return count;
    }
    int findit(int a, int b){
        int count=0;
        HashMap<Integer,Integer> hasha=new HashMap<>();
        HashMap<Integer,Integer> hashb=new HashMap<>();
        while(a>=0 && b>=0 && !(a==0 && b==0)){
            if(a%10 != b%10){
                count++;
                hasha.put(a%10,hasha.getOrDefault(a%10,0)+1);
                hashb.put(b%10,hashb.getOrDefault(b%10,0)+1);
                if(count>2) return count;
            }
            a/=10;
            b/=10;
        }
        if(!hasha.equals(hashb)) return 3;
        return count;
    }
}