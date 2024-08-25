class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<pair> ptr = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair a, pair b) {
                if (a.val != b.val) {
                    return Integer.compare(a.val, b.val); // Descending order of value
                } else {
                    return Integer.compare(a.key, b.key); // Descending order of key
                }
            }
        });
        for(int i=0;i<nums.length;i++){
            ptr.add(new pair(i,nums[i]));
        }
        while(k>0){
            pair etr=ptr.poll();
            ptr.add(new pair(etr.key,etr.val*multiplier));
            k--;
        }
        while(!ptr.isEmpty()){
            pair etr=ptr.poll();
            nums[etr.key]=etr.val;
        }
        return nums;
    }
}
class pair{
    int key;
    int val;
    pair(int i, int j){
        key=i;
        val=j;
    }
}