class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int center = 0; center < s.length(); center++) {
            // Odd-length palindromes (e.g., "aba")
            count += expandFromCenter(s, center, center);

            // Even-length palindromes (e.g., "abba")
            count += expandFromCenter(s, center, center + 1);
        }

        return count;
    }

    private int expandFromCenter(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;     // We found a palindrome from index left to right
            left--;      // Expand to the left
            right++;     // Expand to the right
        }

        return count;
    }
}
