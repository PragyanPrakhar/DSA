class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return solve(s, 0, wordSet, memo);
    }

    private boolean solve(String s, int index, Set<String> wordSet, Boolean[] memo) {
        if (index == s.length()) return true;
        if (memo[index] != null) return memo[index];

        for (int end = index + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(index, end)) && solve(s, end, wordSet, memo)) {
                return memo[index] = true;
            }
        }

        return memo[index] = false;
    }
}
