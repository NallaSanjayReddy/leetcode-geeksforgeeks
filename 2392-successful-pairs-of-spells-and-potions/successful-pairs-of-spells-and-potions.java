class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int ans[]=new int[spells.length];
        Arrays.sort(potions);
        int index=0;
        int count=0;
        for(int i=0;i<spells.length;i++){
            count=0;
            int left=0;
            int right=potions.length-1;
            int mid=0;
            while(left<=right){
                mid = left + (right - left) / 2;
                if(success<=(long)spells[i]*(long)potions[mid]){
                    if((mid>=1 && (long)spells[i]*(long)potions[mid-1]<success) || mid==0){
                        count=(potions.length)-mid;
                        System.out.println(count);
                        break;
                    }
                    else{
                        right=mid-1;
                    }
                }
                else{
                    left=mid+1;
                }
            }
            ans[i]=count;
        }
        return ans;
    }
}