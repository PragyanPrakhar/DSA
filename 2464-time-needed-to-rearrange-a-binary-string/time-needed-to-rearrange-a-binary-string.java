class Solution {
    public int secondsToRemoveOccurrences(String s) {
        StringBuilder sb = new StringBuilder(s);
        int operations = 0;
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '1') {
                    sb.setCharAt(i, '1');
                    sb.setCharAt(i + 1, '0');
                    i++; // Skip next index to avoid double swap
                    swapped = true;
                }
            }
            if (swapped) operations++;
        }
        return operations;
    }
}
