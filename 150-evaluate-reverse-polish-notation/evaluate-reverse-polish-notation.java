class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (!isOperator(token)) {
                st.push(Integer.parseInt(token));
            } else {
                int val1 = 0;
                int val2 = 0;
                if (!st.isEmpty())
                    val1 = st.pop();
                if (!st.isEmpty())
                    val2 = st.pop();
                if (token.equals("+"))
                    st.push(val1 + val2);
                else if (token.equals("-"))
                    st.push(val2 - val1);
                else if (token.equals("/"))
                    st.push(val2 / val1);
                else
                    st.push(val1 * val2);
            }
        }
        return st.peek();
    }

    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*");
    }
}