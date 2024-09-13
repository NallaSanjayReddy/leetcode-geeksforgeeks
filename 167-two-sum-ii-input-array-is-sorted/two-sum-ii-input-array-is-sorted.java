class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(hash.containsKey(target-numbers[i])) return new int[]{hash.get(target-numbers[i])+1,i+1};
            hash.put(numbers[i],i);
        }
        return new int[2];
    }
}