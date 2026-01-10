class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[temperatures.length];
        st.push(0);
        for(int i=1;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                ans[st.peek()]=i-st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            ans[st.peek()]=0;
            st.pop();
        }
        return ans;
    }
}