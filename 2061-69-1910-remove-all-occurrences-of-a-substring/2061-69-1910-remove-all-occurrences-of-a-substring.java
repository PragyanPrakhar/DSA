class Solution {
    public String removeOccurrences(String s, String part) {
        if (s.length() < part.length())
            return s;
        Stack<Character> st = new Stack<>();
        int patternLength = part.length();
        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
            if (s.charAt(i) == part.charAt(patternLength - 1)) {
                int tempIndex = patternLength - 1;
                int count = 0;
                StringBuilder sb = new StringBuilder();
                for (int j = tempIndex; j >= 0; j--) {
                    if (!st.isEmpty() && st.peek() == part.charAt(j)) {
                        sb.append(st.pop());
                        count++;
                    }
                }
                if (count != part.length()) {
                    sb = sb.reverse();
                    for (int k = 0; k < sb.length(); k++) {
                        st.push(sb.charAt(k));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}