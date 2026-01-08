class MinStack {
    Stack<Integer> st;
    Stack<Integer> trackMin;
    public MinStack() {
        st=new Stack<>();
        trackMin=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        ArrayList<Integer> arr=new ArrayList<>();
        int min=-1;
        if(!trackMin.isEmpty()){
            while(!trackMin.isEmpty() && trackMin.peek()<val){
                arr.add(trackMin.pop());
            }
        }
        Collections.sort(arr);
        trackMin.push(val);
        for(int i=arr.size()-1;i>=0;i--){
            trackMin.push(arr.get(i));
        }
    }
    
    public void pop() {
        int poppedValue=st.pop();
        ArrayList<Integer> arr=new ArrayList<>();
        while(trackMin.peek()!=poppedValue && !trackMin.isEmpty()){
            arr.add(trackMin.pop());
        }
        trackMin.pop();
        while(!trackMin.isEmpty()){
            arr.add(trackMin.pop());
        }
        Collections.sort(arr);
        for(int i=arr.size()-1;i>=0;i--){
            trackMin.push(arr.get(i));
        }


    }
    
    public int top() {
        return st.peek();       
    }
    
    public int getMin() {
        return trackMin.peek();
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