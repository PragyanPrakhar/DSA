class MinStack {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MinStack() {
        st1=new Stack<>();
        st2=new Stack<>();
    }
    
    public void push(int val) {
        st1.push(val);
        if(!st2.isEmpty() && st2.peek()>=val){
            st2.push(val);
        }
        else if(st2.isEmpty()){
            st2.push(val);
        }
        
    }
    
    public void pop() {
        int val=st1.pop();
        if(st2.peek()==val) st2.pop();

    }
    
    public int top() {
        return st1.peek();
    }
    
    public int getMin() {
        return st2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */