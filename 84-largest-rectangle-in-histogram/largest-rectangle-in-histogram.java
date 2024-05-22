class Solution {
    public int largestRectangleArea(int[] arr) {
        int[] nsl=new int[arr.length];
        int[] nsr=new int[arr.length];
        Stack<Integer> stkl=new Stack<>();
        Stack<Integer> stkr=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stkl.isEmpty() && arr[stkl.peek()]>=arr[i]){
                stkl.pop();
            }
            if(stkl.isEmpty()) nsl[i]=-1;
            else{
                nsl[i]=stkl.peek();
            }
            stkl.add(i);
        }
        for(int i=arr.length-1;i>=0;i--){
            while(!stkr.isEmpty() && arr[stkr.peek()]>=arr[i]){
                stkr.pop();
            }
            if(stkr.isEmpty()) nsr[i]=arr.length;
            else{
                nsr[i]=stkr.peek();
            }
            stkr.add(i);
        }
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(max<(arr[i]*(nsr[i]-nsl[i]-1))){
                max=arr[i]*(nsr[i]-nsl[i]-1);
            }
        }
        return max;
        
    }
}