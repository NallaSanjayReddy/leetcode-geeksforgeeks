class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stk=new Stack<Integer>();
        LinkedList<Integer> que=new LinkedList<>();
        for(int i=sandwiches.length-1;i>=0;i--){
            stk.push(sandwiches[i]);
        }
        for(int i=0;i<students.length;i++){
            que.add(students[i]);
        }
        int counter=0;
        while(counter!=que.size()){
            if(que.peek()==stk.peek()){
                stk.pop();
                que.poll();
                counter=0;
            }
            else{
                que.add(que.poll());
                counter++;
            }
        }
        return que.size();
    }
}