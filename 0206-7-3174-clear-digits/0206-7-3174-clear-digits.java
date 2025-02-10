class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int digitIndex = -1;
        int charIndex = -1;
        for (int i = 0; i < sb.length();) {
            if (Character.isDigit(sb.charAt(i)) && i >= 1) {
                digitIndex = i;
                int tempIndex = i-1;
                while (tempIndex >= 0) {
                    if (!Character.isDigit(sb.charAt(tempIndex))) {
                        charIndex = tempIndex;
                        break;
                    }
                }
                sb.deleteCharAt(digitIndex);
                sb.deleteCharAt(charIndex);
                i=0;
            }
            else
            {
                i++;
            }
        }
        return sb.toString();

    }
}