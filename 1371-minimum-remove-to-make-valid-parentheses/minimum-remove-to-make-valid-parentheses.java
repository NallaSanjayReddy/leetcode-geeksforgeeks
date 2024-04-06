class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr=s.toCharArray();
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='('){
                count++;
                
            }
            if(arr[i]==')'){
                if(count==0) arr[i]=' ';
                else count--;
            }
        }
        StringBuilder str=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            if(count>0 && arr[i]=='('){
                arr[i]=' ';
                count--;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=' '){
                str.append(arr[i]);
            }
        }
        return str.toString();
    }
}