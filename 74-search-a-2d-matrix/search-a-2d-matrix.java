class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        if(n==1 && m==1) return matrix[0][0]==target;
        int left=0;
        int right=(n*m)-1;
        int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(matrix[mid/(m)][mid%(m)]<target){
                left=mid+1;
            }
            else if(matrix[mid/(m)][mid%(m)]>target){
                right=mid-1;
            }
            else return true;
        }
        return false;
    }
}