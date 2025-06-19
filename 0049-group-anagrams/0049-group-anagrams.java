class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();

        for (String word : strs) {
            int[] freq = new int[26]; // assuming only lowercase letters

            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            // Build a unique string key based on frequency
            StringBuilder sb = new StringBuilder();
            for (int count : freq) {
                sb.append('#'); // separator to avoid ambiguity like 11 vs 1#1
                sb.append(count);
            }

            String key = sb.toString();

            if (!hm.containsKey(key)) {
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(word);
        }

        return new ArrayList<>(hm.values());
    }
}
