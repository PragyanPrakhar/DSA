class Solution {
    boolean isNegative = false;
    int finalAns = 0;

    public int myAtoi(String s) {
        return conversion(s, 0, false, false);
    }

    int conversion(String s, int i, boolean spaceHandled, boolean signHandled) {
        if (i >= s.length()) return isNegative ? -finalAns : finalAns;

        char ch = s.charAt(i);

        if (!spaceHandled && ch == ' ') {
            return conversion(s, i + 1, false, false);
        }

        if (!signHandled && (ch == '+' || ch == '-')) {
            isNegative = (ch == '-');
            return conversion(s, i + 1, true, true);
        }

        if (!Character.isDigit(ch)) {
            return isNegative ? -finalAns : finalAns;
        }

        int digit = ch - '0';

        if (finalAns > (Integer.MAX_VALUE - digit) / 10) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        finalAns = finalAns * 10 + digit;
        return conversion(s, i + 1, true, true);
    }
}

