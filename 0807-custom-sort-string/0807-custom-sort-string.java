class Solution {
    public String customSortString(String order, String s) {
        // HashMap<Character, Integer> hm = new HashMap<>();
        // for (int i = 0; i < order.length(); i++) {
        //     hm.put(order.charAt(i), hm.getOrDefault(order.charAt(i), 0) + 1);
        // }
        // boolean check[]=new boolean[26];
        // Arrays.fill(false,check)
        // int min=-1;
        // ArrayList<Character> arr = new ArrayList<>();
        // String ans = "";
        // String tans = "";
        // for (int i = 0; i < s.length() - 1; i++) {
        //     if (hm.containsKey(s.charAt(i))) {
        //         char temp = ' ';
        //         for (int j = i + 1; j < s.length(); j++) {
        //             if (hm.containsKey(s.charAt(j))) {
        //                 if (hm.get(s.charAt(i)) > hm.get(s.charAt(j))) {
        //                     temp = s.charAt(j);
        //                 }
        //             } else {
        //                 tans += s.charAt(j);
        //             }
        //         }
        //         ans += temp;

        //     } else {
        //         tans += s.charAt(i);
        //     }

        // }
        // return ans + tans;

        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        for (char c : order.toCharArray()) {
            if (mp.containsKey(c)) {
                result.append(String.valueOf(c).repeat(Math.max(0, mp.get(c))));
                mp.remove(c);
            }
        }
        for (char c : mp.keySet()) {
            result.append(String.valueOf(c).repeat(Math.max(0, mp.get(c))));
        }
        return result.toString();
    }
}