import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.isEmpty()) {
            return res;
        }

        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        StringBuilder sb = new StringBuilder();
        recurr(res, sb, digits, hm, 0);

        return res;
    }

    private void recurr(List<String> res, StringBuilder sb,
            String digits, HashMap<Character, String> mapping,
            int ind) {

        if (ind == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String letters = mapping.get(digits.charAt(ind));

        for (int j = 0; j < letters.length(); j++) {
            sb.append(letters.charAt(j));

            recurr(res, sb, digits, mapping, ind + 1);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}