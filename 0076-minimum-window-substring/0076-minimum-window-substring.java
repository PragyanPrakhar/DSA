class Solution {
    public String minWindow(String s, String t) {
        int end = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        if(t.length()>s.length()) return "";
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        String ans = "";
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int minStart=0;
        int formed = 0;
        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (tMap.containsKey(endChar)) {
                windowMap.put(endChar, windowMap.getOrDefault(endChar, 0) + 1);
                if (windowMap.get(endChar).equals(tMap.get(endChar))) {
                    formed++;
                }
            }
            while (formed == tMap.size()) {
                if (end - start + 1 < minLen) {
                    minLen=end-start+1;
                    minStart=start;
                }
                char startChar=s.charAt(start);
                if(tMap.containsKey(startChar)){
                    windowMap.put(startChar,windowMap.get(startChar)-1);
                    if(windowMap.get(startChar)<tMap.get(startChar)){
                        formed--;
                    }
                }
                start++;
            }
            end++;
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);

    }
}