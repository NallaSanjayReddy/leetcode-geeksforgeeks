class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()) return "0";
        PriorityQueue<int[]> ptr = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        char[] arr = num.toCharArray();
        for(int i = 0; i < arr.length; i++){
            while(!ptr.isEmpty() && (ptr.peek()[0]) > (arr[i] - '0') && k > 0){ 
                int[] itr = ptr.poll();
                arr[itr[1]] = '*';
                k--;
            }
            ptr.offer(new int[]{arr[i]-'0',i});
        }
        for(int i = arr.length - 1; i >= 0 && k > 0; i--){
            if(arr[i] != '*'){ 
                arr[i] = '*';
                k--;
            }
        }
        StringBuilder str = new StringBuilder();
        boolean leadingZero = true;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '*'){
                continue;
            }
            if(arr[i] == '0' && leadingZero){
                continue;
            }
            leadingZero = false;
            str.append(arr[i]);
        }
        return str.length() == 0 ? "0" : str.toString();
    }
}

