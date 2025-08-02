class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            // Resolve collision only if top is positive and current is negative
            while (!st.isEmpty() && asteroid < 0 && st.peek() > 0) {
                int top = st.peek();
                if (top < -asteroid) {
                    st.pop(); // Top explodes, current continues
                } else if (top == -asteroid) {
                    st.pop(); // Both explode
                    destroyed = true;
                    break;
                } else {
                    // Current asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}
