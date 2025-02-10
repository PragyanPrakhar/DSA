class Solution {
    private boolean isPallindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        int index = 0;
        partioning(s, temp, ans, index);
        return ans;
    }

    private void partioning(String s, List<String> temp, List<List<String>> ans, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPallindrome(s, index, i)) {
                temp.add(s.substring(index, i + 1));
                partioning(s, temp, ans, i + 1);
                temp.remove(temp.size() - 1);
            }
        }

    }
}