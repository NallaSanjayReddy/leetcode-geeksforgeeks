class Solution {
	public int minAbsoluteDifference(List<Integer> nums, int x) {
		int min = Integer.MAX_VALUE;
		TreeSet<Integer> ts = new TreeSet<>();
		for(int i=x;i<nums.size();i++){
			ts.add(nums.get(i-x));
			Integer ceiling = ts.ceiling(nums.get(i));
			if(ceiling!=null)
				min = Math.min(min,Math.abs(nums.get(i)-ceiling));
			Integer floor = ts.floor(nums.get(i));
			if(floor!=null)
				min = Math.min(min,Math.abs(nums.get(i)-floor));
		}
		return min;
	}
}