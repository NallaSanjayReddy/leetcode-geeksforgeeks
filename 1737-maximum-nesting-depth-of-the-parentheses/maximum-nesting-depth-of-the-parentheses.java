class Solution {
    public int maxDepth(String s) {
        Stack<Character> stk=new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stk.add('(');
            if(s.charAt(i)==')') stk.pop();
            if(count<stk.size()) count=stk.size();
        }
        return count;
    }
}