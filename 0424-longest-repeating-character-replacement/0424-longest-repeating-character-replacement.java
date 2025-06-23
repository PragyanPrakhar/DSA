class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxCount = 0;
        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            freq[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(end) - 'A']);

            // If the remaining characters are more than k, shrink the window
            while ((end - start + 1) - maxCount > k) {
                freq[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
