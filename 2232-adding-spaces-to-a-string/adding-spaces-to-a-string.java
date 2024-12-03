class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str=new StringBuilder(s);
        int count=0;
        for(int ele:spaces){
            str.insert(ele+count,' ');
            count++;
        }
        return str.toString();
    }
}