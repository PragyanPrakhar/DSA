class Solution {
    public String FirstNonRepeating(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> hm = new HashMap<>();
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 1. Update frequency
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            // 2. Add to queue
            q.offer(ch);

            // 3. Remove all characters from front which are repeated
            while (!q.isEmpty() && hm.get(q.peek()) > 1) {
                q.poll();
            }

            // 4. Append result
            if (q.isEmpty()) {
                sb.append('#');
            } else {
                sb.append(q.peek());
            }
        }

        return sb.toString();
    }
}
