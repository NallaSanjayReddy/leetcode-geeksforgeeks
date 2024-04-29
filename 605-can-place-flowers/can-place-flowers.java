class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        int val=0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                count++;
            }
            if(flowerbed[i]==1 && count!=0){
                if(count==i) val+=count/2;
                else val+=(count-1)/2;
                count=0;
            }
        }
        if(count==flowerbed.length) val+=(count+1)/2;
        else val+=count/2;
        if(val>=n) return true;
        return false;
    }
}