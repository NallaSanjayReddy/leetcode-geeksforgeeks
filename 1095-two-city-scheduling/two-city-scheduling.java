class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(a,b)->((a[0]-b[0])+(b[1]-a[1])));
        int sum=0;
        for(int i=0;i<costs.length;i++){
            if(i<=(costs.length-1)/2) sum+=costs[i][0];
            else sum+=costs[i][1];
        }
        return sum;
        
    }
}