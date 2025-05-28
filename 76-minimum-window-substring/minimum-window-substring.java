class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int formed = 0; // Number of characters meeting the required count

        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (tMap.containsKey(endChar)) {
                windowMap.put(endChar, windowMap.getOrDefault(endChar, 0) + 1);
                if (windowMap.get(endChar).intValue() == tMap.get(endChar).intValue()) {
                    formed++;
                }
            }

            while (formed == tMap.size()) {
                // Update min window
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                char startChar = s.charAt(start);
                if (tMap.containsKey(startChar)) {
                    windowMap.put(startChar, windowMap.get(startChar) - 1);
                    if (windowMap.get(startChar) < tMap.get(startChar)) {
                        formed--;
                    }
                }
                start++;
            }

            end++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
