class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[][] answer=new int[matrix.length][matrix[0].length];
        LinkedList<Integer> arr=new LinkedList<>();
        int max=0;
        for(int i=0;i<matrix[0].length;i++){
            max=0;
            for(int j=0;j<matrix.length;j++){
                if(matrix[j][i]==-1){
                    arr.add(j);
                }
                else{
                    answer[j][i]=matrix[j][i];
                    if(max<matrix[j][i]){
                        max=matrix[j][i];
                    }
                }
            }
            while(!arr.isEmpty()){
                answer[arr.poll()][i]=max;
            }
        }
        return answer;
        
    }
}