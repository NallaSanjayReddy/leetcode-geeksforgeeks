class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> circle=new LinkedList<>();
        for(int i=1;i<=n;i++){
            circle.add(i);
        }
        while(circle.size()>1){
            int count=1;
            while(count<k){
                circle.add(circle.poll());
                count++;
            }
            circle.poll();
        }
        return circle.poll();
    }
}