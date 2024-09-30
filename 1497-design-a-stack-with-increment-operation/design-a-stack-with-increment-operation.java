class CustomStack {
    LinkedList<Integer> stkk;
    LinkedList<Integer> stk;
    int maxSize;
    public CustomStack(int maxSize) {
        this.maxSize=maxSize;
        stk=new LinkedList<>();
    }
    
    public void push(int x) {
        if(stk.size()<maxSize){
            stk.add(x);
        }
    }
    
    public int pop() {
        if(stk.size()!=0) return stk.pollLast();
        else return -1;
    }
    
    public void increment(int k, int val) {
        stkk=new LinkedList<>();
        for(int ele:stk){
            if(k>0){
                stkk.add(ele+val);
                k--;
            }
            else stkk.add(ele);
        }
        stk=new LinkedList<>(stkk);
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */