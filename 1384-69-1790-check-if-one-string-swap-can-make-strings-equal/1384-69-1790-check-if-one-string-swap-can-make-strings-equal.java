class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (!hm.containsKey(s2.charAt(i)))
                return false;
            hm.put(s2.charAt(i), hm.get(s2.charAt(i)) - 1);
        }
        for (int i = 0; i < s1.length(); i++) {
            if (!hm.containsKey(s2.charAt(i)))
                return false;
            if (s1.charAt(i) == s2.charAt(i) && hm.get(s2.charAt(i)) != 0)
                return false;
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        }
        if (count == 2 || count == 0)
            return true;
        return false;
    }
}