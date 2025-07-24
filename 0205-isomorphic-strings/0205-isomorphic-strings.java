class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (hm.containsKey(charS)) {
                if (hm.get(charS) != charT) {
                    return false; 
                }
            } else {
                if (hm.containsValue(charT)) {
                    return false;
                }
                hm.put(charS, charT);
            }
        }
        return true;
    }
}
