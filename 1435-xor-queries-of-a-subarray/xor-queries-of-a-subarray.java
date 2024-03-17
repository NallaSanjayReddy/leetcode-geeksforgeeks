// In-place calculate the prefix XOR of input A.

// For each query [i, j],
// if i == 0, query result = A[j]
// if i != 0, query result = A[i - 1] ^ A[j]


class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        for(int i=1; i<arr.length; i++){
            arr[i] = arr[i-1]^arr[i];
        }

        int[] xor = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            if(queries[i][0]>0){
                xor[i] = arr[queries[i][1]]^arr[queries[i][0]-1];
            } else{
                xor[i] = arr[queries[i][1]];
            }
        }
        return xor;
    }
}