class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            String result = "";
            for (int i = 0; i < s.length(); i = i + k) {
                int currentSum = 0;
                String group = s.substring(i, Math.min(i + k, s.length()));
                for (int j = 0; j < group.length(); j++) {
                    currentSum += group.charAt(j) - '0';
                }
                result += currentSum;
            }
            s = result;
        }
        return s;
    }
}