class Solution {
    public int maxDepth(String s) {
        int max=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char currentChar=s.charAt(i);
            if(currentChar == '('){
                st.push(currentChar);
                max=Math.max(max,st.size());
            }
            if(currentChar==')'){
                st.pop();
            }
        }
        return max;
        
    }
}