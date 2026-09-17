class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        int start = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, hm.get(ch));

            while ((end - start + 1) - maxFreq > k) {
                char leftChar = s.charAt(start);
                hm.put(leftChar, hm.get(leftChar) - 1);
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}