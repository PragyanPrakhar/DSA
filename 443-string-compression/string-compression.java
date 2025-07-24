class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;

        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && chars[j] == chars[i]) {
                j++;
            }
            chars[write++] = chars[i];

            int count = j - i;
            if (count > 1) {
                String cnt = Integer.toString(count);
                for (char c : cnt.toCharArray()) {
                    chars[write++] = c;
                }
            }
            i = j;
        }
        return write;
    }
}
