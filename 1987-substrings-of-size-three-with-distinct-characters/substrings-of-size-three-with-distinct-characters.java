class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            if (right - left + 1 == 3) {

                char a = s.charAt(left);
                char b = s.charAt(left + 1);
                char c = s.charAt(right);

                if (a != b && b != c && a != c) {
                    count++;
                }

                left++;
            }
        }

        return count;
    }
}