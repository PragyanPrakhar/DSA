class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1FreqMap = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            s1FreqMap.put(ch, s1FreqMap.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> currentWindowMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int windowLength = s1.length();
        while (end < s2.length()) {
            if (!s1FreqMap.containsKey(s2.charAt(end))) {
                currentWindowMap.clear();
                start = end + 1;
                end++;
                continue;
            } else if (s1FreqMap.containsKey(s2.charAt(end))) {
                currentWindowMap.put(s2.charAt(end), currentWindowMap.getOrDefault(s2.charAt(end), 0) + 1);
                if(end-start+1 == windowLength) {
                    if(currentWindowMap.equals(s1FreqMap)) return true;
                    else{
                        currentWindowMap.put(s2.charAt(start),currentWindowMap.get(s2.charAt(start))-1);
                        if(currentWindowMap.get(s2.charAt(start))==0){
                            currentWindowMap.remove(s2.charAt(start));
                        }
                        start=start+1;
                    }
                }
            }
            end++;
        }
        return false;

    }
}