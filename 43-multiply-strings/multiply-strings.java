class Solution {
    public String multiply(String num1, String num2) {
        if(num2.equals("0") || num1.equals("0")) return "0";
        StringBuilder[] arr=new StringBuilder[num1.length()];
        StringBuilder str=new StringBuilder();
        int carry=0;
        for(int i=num1.length()-1;i>=0;i--){
            arr[i]=new StringBuilder(str);
            carry=0;
            for(int j=num2.length()-1;j>=0;j--){
                int val=(num2.charAt(j)-'0')*(num1.charAt(i)-'0');
                val+=carry;
                arr[i].append(val%10);
                carry=val/10;
            }
            if(carry!=0) arr[i].append(carry);
            str.append('0');
        }
        StringBuilder ans=new StringBuilder(arr[0]);
        for(int i=1;i<arr.length;i++){
            int carry2=0;
            int j=0;
            while(j<=Math.min(ans.length()-1,arr[i].length()-1)){
                int val=(ans.charAt(j)-'0')+(arr[i].charAt(j)-'0')+carry2;
                ans.replace(j,j+1,(val%10)+"");
                carry2=val/10;
                j++;
            }
            while(j>arr[i].length()-1 && j<=ans.length()-1){
                int val=(ans.charAt(j)-'0')+carry2;
                ans.replace(j,j+1,(val%10)+"");
                carry2=val/10;
                j++;
            }
            while(j>ans.length()-1 && j<=arr[i].length()-1){
                int val=(arr[i].charAt(j)-'0')+carry2;
                ans.append(val%10);
                carry2=val/10;
                j--;
            }
            if(carry2!=0) ans.append(carry2);
        }
        return ans.reverse().toString();
    }
}