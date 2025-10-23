class Solution {
    public boolean hasSameDigits(String s) {
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1))
                return true;
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        StringBuilder swap = new StringBuilder();

        for (int i = 0; i < sb.length() - 1; i++) {
            int tempSum = ((sb.charAt(i) - '0') + (sb.charAt(i + 1) - '0')) % 10;
            swap.append((char)(tempSum + '0'));

            if (i == sb.length() - 2) {
                if (swap.length() == 2 && swap.charAt(0) == swap.charAt(1)) {
                    return true;
                }
                if (swap.length() == 1) break;

                sb.setLength(0);
                sb.append(swap);
                swap.setLength(0);
                i = -1;
            }
        }
        return false;
    }
}
