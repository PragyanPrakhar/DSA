class Solution {
    public int secondsToRemoveOccurrences(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int prevIndex = -1;
        char prevChar = '$';
        int numberOfOperations = 0;
        boolean p = true;
        while (p) {
            boolean q = false;
            for (int i = 0; i < s.length(); i++) {
                if (sb.charAt(i) == '1' && prevChar == '0') {
                    sb.setCharAt(i - 1, '1');
                    sb.setCharAt(i, '0');
                    i++;
                    q = true;
                }
                if(i>sb.length()-1) break;
                prevChar = sb.charAt(i);
            }
            if (q)
                numberOfOperations++;
            if (!q)
                p = false;
            prevChar = '$';
        }
        return numberOfOperations;
    }
}