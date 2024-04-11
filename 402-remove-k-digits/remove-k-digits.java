class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()) return "0";
       PriorityQueue<String> ptr = new PriorityQueue<>((a, b) -> {
            int digitA = a.charAt(0) - '0';
            int digitB = b.charAt(0) - '0';
            return Integer.compare(digitB, digitA);
        });
        
        char[] arr = num.toCharArray();
        for(int i = 0; i < arr.length; i++){
            while(!ptr.isEmpty() && (ptr.peek().charAt(0) - '0') > (arr[i] - '0') && k > 0){ 
                String itr = ptr.poll();
                // Correctly parse the index part of the string
                int index = Integer.parseInt(itr.substring(1));
                arr[index] = '*';
                k--;
            }
            // Store the digit and index as a string, ensuring index is correctly represented
            ptr.offer(arr[i] +""+i);
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

