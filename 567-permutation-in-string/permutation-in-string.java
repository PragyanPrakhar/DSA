class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
            hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
        }
        int wS = s1.length();
        for (int i = 0; i <= s2.length() - wS; i++) {
            for (int j = i; j < i + wS; j++) {
                if (hm1.containsKey(s2.charAt(j))) {
                    hm1.put(s2.charAt(j), hm1.get(s2.charAt(j)) - 1);
                    if (hm1.get(s2.charAt(j)) == 0)
                        hm1.remove(s2.charAt(j));
                    if (hm1.size() == 0)
                        return true;
                }
            }
            hm1 = new HashMap<>(hm2);
        }
        return false;

    }
}