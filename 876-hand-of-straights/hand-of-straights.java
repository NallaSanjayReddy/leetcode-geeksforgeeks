class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int count=0;
        for(int i=0;i<hand.length;i++){
            if(hand[i]>=0){
                int prev=hand[i];
                count=1;
                hand[i]=-1;
                for(int j=i+1;j<hand.length && count<groupSize;j++){
                    if(hand[j]>=0 && hand[j]==prev+1){
                        prev=hand[j];
                        count++;
                        hand[j]=-1;
                    }
                }
                if(count!=groupSize) return false;
            }
        }
        return true; 
    }
}