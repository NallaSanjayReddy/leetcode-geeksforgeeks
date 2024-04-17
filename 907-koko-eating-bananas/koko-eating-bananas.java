class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int sum=0;
        Arrays.sort(piles);
        if(h==piles.length) return piles[piles.length-1];
        int l=1;
        int r=piles[piles.length-1];
        int mid=0;
        while(l<r){
            mid=l+(r-l)/2;
            long val=0;
            for(int j=0;j<piles.length;j++){
                if(val>h){
                    break;
                }
                val+=(long)Math.ceil((double)piles[j]/mid);
            }
            if(val>h){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
}