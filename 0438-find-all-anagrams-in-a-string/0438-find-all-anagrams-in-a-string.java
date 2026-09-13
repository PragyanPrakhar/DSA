class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length(), windowLength = p.length();
        if (n < windowLength)
            return ans;

        HashMap<Character, Integer> pFreqMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pFreqMap.put(c, pFreqMap.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> currentWindowFreqMap = new HashMap<>();
        int start = 0;
        for (int end = 0; end < n; end++) {
            char inChar = s.charAt(end);
            currentWindowFreqMap.put(inChar, currentWindowFreqMap.getOrDefault(inChar, 0) + 1);

            if (end - start + 1 > windowLength) {
                char outChar = s.charAt(start);
                int count = currentWindowFreqMap.get(outChar) - 1;
                if (count == 0)
                    currentWindowFreqMap.remove(outChar);
                else
                    currentWindowFreqMap.put(outChar, count);
                start++;
            }

            if (end - start + 1 == windowLength && currentWindowFreqMap.equals(pFreqMap)) {
                ans.add(start);
            }
        }
        return ans;
    }
}